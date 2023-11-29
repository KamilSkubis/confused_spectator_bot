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

(defn time-endpoints []
  (pmap #(time (slurp %)) pings)) 
    )