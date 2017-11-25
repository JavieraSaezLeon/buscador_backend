# Buscador BackEnd

## Requisitos
- maven
- Java 7
- Mysql
- Phpmyadmin

## Clonar buscador BackEnd
- git clone https://github.com/JavieraSaezLeon/buscador_backend.git


## Instalacion

- sudo apt-get install apache2
- sudo apt-get install mysql-server
- sudo apt-get install phpmyadmin
- Seleccionar si cuando pregunte por la config de la bd, luego apretar espacio, tab y enter para  seleccionar apache2 cuando pregunte.
- sudo /etc/init.d/apache2 restart

-+-
- En caso de errores borrar y re intentar:
- sudo dpkg -P phpmyadmin
- sudo rm -f /etc/apache2/conf-available/phpmyadmin.conf
-+-

Maven
- sudo mv ~/Downloads/apache-maven-3.5.2 /opt
- sudo gedit /etc/bash.bashrc
- export MAVEN_HOME=/opt/apache-maven-3.3.9
- export M2_HOME=/opt/apache-maven-3.3.9
- export PATH=$PATH:$M2_HOME/bin

- o

- sudo apt-get install maven

## Base de datos
- cd buscador_backend/src/main/resources/script/
- Instalar booksd.sql en MySQL, es decir abrir phpmyadmin y cargar la base de datos
- Como la base de datos es muy grande es necesario editar el archivo php.ini 
- sudo gedit /etc/php/7.0/apache2/php.ini o
- sudo nano /etc/php/7.0/apache2/php.ini

Una vez abierto el editor nano, pulsamos la tecla Ctrl+w y buscamos la palabra post_max_size y le aumentamos su valor a 1024M por ejemplo y Ahora buscamos upload_max_filesize y subimos su valor a 1000M.  Y guardamos el documento pulsando  Ctrl+O 
En phpmyadmin desactivar la casilla de Partial import para que carga de una sola carga la base Book


## Ejecutar BackEnd
### IDE
  - Ejecutar por medio de IDE Netbeans
### Por consola
- cd buscador_backend
- mvn clean install
- cd target
- java jar demo-0.0.1-SNAPSHOT.jar -h
- comprobar en http://localhost:8090/

## Referencias

Para mayor referencias de como funciona el Front dirigirse a la wiki del proyecto: https://github.com/JavieraSaezLeon/buscador_backend/wiki
