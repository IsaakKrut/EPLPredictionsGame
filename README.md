# EPLPredictionsGame
Used to identify the winner of a game between me and my friends, based on predictions before the start of English Premier League season.

It retrieves the current table from a REST API using OkHttpClient and saves the JSON string to a file. Then it reads it back from that file using JSON simple library.
This is done to limit the number of GET requests to the API, as only 50 are allowed each month.
