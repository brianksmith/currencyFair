# currencyFair

  This is a single server instance but it can easily be deployed in a cluster.  The cluster instance would include a load balancer that round robins requests to x server instances.  Each instance would push requests to MQ which is then scrubbed and put into redis for metrics evaluation.  I have completed all the steps but more is needed to expand out the metrics and viewing of the metrics.
  
 1. install activeMQ (brew install activeMQ)
 2. install redis (brew install redis)
 3. install gradle (brew install gradle)
 4. run app (gradle jettyRun)
 
 Add a trasaction
  curl -H "Content-Type: application/json" -X POST -d '{"userId": "134256", "currencyFrom": "GBP", "currencyTo": "USD",  "amountSell": 1000, "amountBuy": 747.10, "rate": 0.7471, "timePlaced" : "14-JAN-15 10:27:44", "originatingCountry" : "FR"}' http://localhost:8080/CurrencyMarketTrader/currency/trade

 View Metric
 http://localhost:8080/CurrencyMarketTrader/donut
