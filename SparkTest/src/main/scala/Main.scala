/**
  * Created by karvalhus on 12/01/17.
  */
import org.apache.spark._
import com.mongodb.spark._
import org.bson.Document

object Main extends App{

  val conf = new SparkConf()
    .setAppName("SparkTest")
    .setMaster("local")
    .set("spark.mongodb.input.uri", "mongodb://127.0.0.1/twitter.tweets")
    .set("spark.mongodb.output.uri", "mongodb://127.0.0.1/twitter.test")

  val sc = new SparkContext(conf)

  val rddTweets = MongoSpark.load(sc)

  val anwserCollection = rddTweets
    .map(rt => (rt
      .get("lang"), 1))
    .reduceByKey(_ + _)

  anwserCollection.map( tuple => {

    val doc = new Document()
    doc.put("_id", tuple._1)
    doc.put("value", tuple._2)
    doc
  }).saveToMongoDB()

}
