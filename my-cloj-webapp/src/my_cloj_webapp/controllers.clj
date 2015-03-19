(ns my-cloj-webapp.controllers
  (:require [taoensso.carmine :as car :refer (wcar)]))

(def server1-conn {:pool {} :spec {:host "new-red" :port 6379}})
(defmacro wcar* [& body] `(car/wcar server1-conn ~@body))
(defn hash-link [link] (str (hash link)))

(defn validate-url [url]
  (let
    [found (re-find #"^(https?|ftp|file)://[\w]*\.\w{1,3}[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]*?" url)]
    (if (nil? found) false true)))

(defn get-link
  [shortened-link]
  (wcar* (car/get (str shortened-link))))

(defn set-link
  [link]
  (if (validate-url link)
    (let [hashed-link (hash-link link)]
      (wcar* (car/set hashed-link link))
      hashed-link)
    false))