(ns confused-spectator-bot.core
  (:gen-class)
  (:require [clojure.data.json :as json]))


(defn get-data-from-binance-USDT
  "getting data from binance"
  []
  (let [binance-core-addr "https://api.binance.com"
        binance-data-endpoint "/api/v3/exchangeInfo"
        url (str binance-core-addr binance-data-endpoint)]
    (json/read-str (slurp url))))


