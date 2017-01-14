/**
  * Created by karvalhus on 11/01/17.
  */
import org.mongodb.scala._

object Main extends App{

  val mongoClient: MongoClient = MongoClient("mongodb://localhost:27017")

  val database: MongoDatabase = mongoClient
    .getDatabase("twitter")

  val tweets: MongoCollection[Document] = database
    .getCollection("tweets")

  tweets
    .mapReduce("function() {emit(this.lang, 1);};"
        , "function(keyLang, count) {return Array.sum(count);};")
    .collectionName("mapReduceRetweets")
    .subscribe(new Observer[Document] {

      override def onNext(doc: Document) = println(doc.toJson())

      override def onError(erro: Throwable) = println(s"error: ${erro}")

      override def onComplete() = mongoClient.close()
    }
    )

  Thread.sleep(1000)
}
