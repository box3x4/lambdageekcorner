#Processamento de dados usando Spark + MongoDB / Data processing using Spark + MongoDB

Esse é o código do segundo post do meu blog, mostrando um exemplo simple de processamento de dados usando o MongoDB como fonte dos dados para o Apache Spark.É preciso ter o mongoDB, Scala, sbt e Apache Spark instalados para poder executa-lo. Para executa-lo, siga os passos:

    inicie sua instância do mongoDB com o comando "mongod";
    importe a coleção de tweets, usando o comando "mongoimport --db twitter --collection tweets --file tweets_westworld.json";
    entre na pasta em que o código foi extraído(no caso, SparkTest);
    entre no prompt do sbt, usando o comando "sbt";
    dentro do prompt do sbt, use o comando "run", que irá compilar e rodar o código.

This is the code from my second blog post, showing a simple example of data processing using MongoDB as source of the data for Apache Spark. You need to install mongoDB, Scala, sbt and Apache Spark to run this code. To run it[the code], follow the steps:

    start your mongoDB instance with the "mongod" command;
    import the tweets collection, using the "mongoimport --db twitter --collection tweets --file tweets_westworld.json" command;
    go to the code's directory(in this case, MapReduceMongo);
    enter the sbt command line, with the "sbt" command;
    once in the cli, use the "run" command, which will compile and run the code.
