# EPLPredictionsGame
Used to identify the winner of a game between me and my friends, based on the prediction, made about English Premier League before start of the season.

It retrieves the current table from a REST API using OKHttpClient, saves the JSON string to a file, then reads it back using JSON simple library.
It is done to limit the number of GET requests, made to the API as only 50 requests per month is allowed.


