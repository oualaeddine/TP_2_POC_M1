//compiler les classes
javac *.java -d out
javac StockServeur.java -d out/server -classpath out/server
//generer le fichier stub
rmic StokImpl -classpath out/server

//lancer
java -cp . StockServeur -Djava.security.policy=file:C:/Users/berre/Desktop/TP2_POC/out/server/security.policy  -Djava.rmi.server.codebase=file:C:/Users/berre/Desktop/TP2_POC/out/server
java -cp . Client1
java -cp . Client2 
java -cp . Client3