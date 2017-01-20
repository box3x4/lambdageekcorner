var mongodb = require('mongodb');
var MongoClient = mongodb.MongoClient;
var twitter = require('twitter');

var client = new twitter({
  consumer_key: '',
  consumer_secret: '',
  access_token_key: '',
  access_token_secret: ''
});

var base;

MongoClient.connect('mongodb://localhost:27017/twitter', function(errB, db) {

  if (errB) {

    console.log('erro na conexão banco');

    base.close();
  } else {

    base = db;
  }
});

client.stream('statuses/filter', {track: 'westworld'}, function(stream) {

  stream.on('data', function(tweet) {

    base.collection('tweets').insert(tweet, function(errSB, res) {

      if (errSB) {

        console.log('erro ao inserir no banco');

        base.close();
      } else {

        console.log(tweet);

        console.log(res);
      }
    });
  });

  stream.on('error', function(errS) {

    console.log('erro na stream do twitter '+errS);

    base.close();
  });
});
