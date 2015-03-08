(ns my-cloj-webapp.handler
  (:require [my-cloj-webapp.views :as views]
            [compojure.core :as cc]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]])
  (:gen-class :main true))



(cc/defroutes app-routes
  (cc/POST "/"
    {params :params}
    (views/shorten params))
  (cc/GET "/"
    []
    (views/home))
  (cc/GET "/:link"
    [link]
    (views/shortened-link link))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app (handler/site app-routes))

(defn -main
  [& [port]]
  (let [port (Integer. (or port
                         (System/getenv "PORT")
                         5000))]
    (jetty/run-jetty #'app {:port  port
                            :join? false})))