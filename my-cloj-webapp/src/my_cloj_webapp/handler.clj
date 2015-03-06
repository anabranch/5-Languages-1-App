(ns my-cloj-webapp.handler
  (:require [my-cloj-webapp.views :as views]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))



(defroutes app-routes
  (GET "/" [] (views/test-hello))
  (GET "/:link" [link] (views/shortened))
;  (GET "/shorten/:link" [link] (views/shorten link))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
