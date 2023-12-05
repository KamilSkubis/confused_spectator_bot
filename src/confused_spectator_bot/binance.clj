(ns confused-spectator-bot.binance
  (:require [clojure.data.json :as json]
            [clj-http.client :as client]))

(def atom ({:used-weight 0
:used-weight-1m 0 }))

(def core-url ["https://api.binance.com",
               "https://api-gcp.binance.com",
               "https://api1.binance.com",
               "https://api2.binance.com",
               "https://api3.binance.com",
               "https://api4.binance.com"])

(def ping "/api/v3/ping")
(def servertime "/api/v3/time")
(def klines "/api/v3/klines")


(defn get-tickers-usdt
  "get tickers from binance in with second currency as USDT"
  []
  (let [binance-core-addr "https://api.binance.com"
        binance-data-endpoint "/api/v3/ticker/24hr"
        url (str binance-core-addr binance-data-endpoint)
        response (json/read-str (slurp url) :key-fn keyword)]
    (filter #(.endsWith % "USDT") (map #(:symbol %) response))))





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


  (def test-ticker "ETHUSDT")
  (json/read-str (:body (client/get "https://api.binance.com/api/v3/time")))


  ;;use UpperCase for symbols
  (defn request-klines [endpoint symbol timeframe]
    (let [data {}
          url (str endpoint "?symbol=" symbol "&interval=" timeframe)
          response (client/get url)]
      (-> data
          (assoc :x-mbx-used-weight (get-in response [:headers "x-mbx-used-weight"])
                 :x-mbx-used-weight-1m (get-in response [:headers "x-mbx-used-weight-1m"])
                 :status (:status response)
                 :body  (json/read-str (:body response) )))))


  ;;get 5m klines for ETHUSDT
  (def test-data (request-klines "https://api.binance.com/api/v3/klines" "ETHUSDT" "1m"))



  )

 
 