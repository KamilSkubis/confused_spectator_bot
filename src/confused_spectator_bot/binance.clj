(ns confused-spectator-bot.binance
  (:require [clojure.data.json :as json]))

(def core-url ["https://api.binance.com",
               "https://api-gcp.binance.com",
               "https://api1.binance.com",
               "https://api2.binance.com",
               "https://api3.binance.com",
               "https://api4.binance.com"])

(def ping-endpoint "/api/v3/ping")




(comment

  (def pings (mapv #(str % ping-endpoint) core-url))
  ;;looking for best binance api server
  (defn time-endpoints []
    (pmap #(time (slurp %)) pings))
  
  "Elapsed time: 400.9164 msecs"
  "Elapsed time: 1074.0532 msecs"
  "Elapsed time: 1086.3397 msecs"
  "Elapsed time: 1100.6834 msecs"
  "Elapsed time: 1122.5045 msecs"
  "Elapsed time: 1150.2397 msecs"


  
  
  )