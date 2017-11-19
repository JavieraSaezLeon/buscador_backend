package com.example.demo.lucene;

import com.example.demo.domain.BX_Books;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Searcher;

public class Index {
    
    final File INDEX_DIR;

    public Index() {
        this.INDEX_DIR  = new File("index");
    }
    
    public Connection getConnection() throws FileNotFoundException, IOException, SQLException{
        InputStream input = null;
	Properties prop = null;
        input = new FileInputStream("src/main/resources/application.properties");
        prop = new Properties();
        prop.load(input);
        Connection connection = 
                DriverManager.getConnection(
                prop.getProperty("spring.datasource.url"), 
                prop.getProperty("spring.datasource.username"), 
                prop.getProperty("spring.datasource.password"));
        return connection;
    }
       
    public void indexingDB() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, SQLException, Exception{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        try {
            Connection connection = getConnection();
            StandardAnalyzer analyzer = new StandardAnalyzer();
            IndexWriter writer = new IndexWriter(INDEX_DIR, analyzer, true);
            indexDocs(writer, connection);
            writer.optimize();
            writer.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void indexDocs(IndexWriter writer, Connection conn) throws Exception {
        String sql = "select isbn, booktitle, bookauthor, yearofpublication,  publisher, imageurls, imageurlm, imageurll from bx_books";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Document d = new Document();
            d.add(new Field("isbn", rs.getString("isbn"), Field.Store.YES, Field.Index.NO));
            d.add(new Field("booktitle", rs.getString("booktitle"), Field.Store.NO, Field.Index.TOKENIZED));
            d.add(new Field("bookauthor", rs.getString("bookauthor"),Field.Store.NO, Field.Index.TOKENIZED));
            d.add(new Field("yearofpublication", rs.getString("yearofpublication"), Field.Store.NO, Field.Index.TOKENIZED));
            d.add(new Field("publisher", rs.getString("publisher"),Field.Store.NO, Field.Index.TOKENIZED));
            d.add(new Field("imageurls", rs.getString("imageurls"),Field.Store.NO, Field.Index.TOKENIZED));
            d.add(new Field("imageurlm", rs.getString("imageurlm"),Field.Store.NO, Field.Index.TOKENIZED));
            d.add(new Field("imageurll", rs.getString("imageurll"),Field.Store.NO, Field.Index.TOKENIZED));
            writer.addDocument(d);
       }
    }
    
    public List<BX_Books> searchInIndex(String word) throws IOException, ParseException, FileNotFoundException, SQLException{
        List<BX_Books> books = new ArrayList<BX_Books>();
        Searcher searcher = new IndexSearcher(IndexReader.open("index"));
        StandardAnalyzer analyzer = new StandardAnalyzer();
        Query query = new QueryParser("booktitle",analyzer).parse(word);
        Hits hits = searcher.search(query);
        String sql = "select * from bx_books where isbn = ?";
        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        for (int i = 0; i < hits.length(); i++){
            String isbn = hits.doc(i).get("isbn");
            pstmt.setString(1, isbn);
            displayResults(pstmt, books);
        }   
        return books;
    }
    
    public void displayResults(PreparedStatement pstmt, List<BX_Books> books) {
        
        try {
           ResultSet rs = pstmt.executeQuery();
           while (rs.next()) {
                BX_Books book = new BX_Books();
                book.setIsbn(rs.getString("isbn"));
                book.setBooktitle(rs.getString("booktitle"));
                book.setImageurls(rs.getString("imageurls"));
                book.setImageurlm(rs.getString("imageurlm"));
                book.setImageurll(rs.getString("imageurll"));
                book.setPublisher(rs.getString("publisher"));
                book.setBookauthor(rs.getString("bookauthor"));
                book.setYearofpublication(rs.getInt("yearofpublication"));
                books.add(book);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, SQLException, Exception{
        System.err.println("PROBANDO EL INDIXING");
        Index index = new Index();
        // Solo se descomenta está línea si el indice no está creado.
        index.indexingDB();
        List<BX_Books> books= index.searchInIndex("Classical");
    }
}
