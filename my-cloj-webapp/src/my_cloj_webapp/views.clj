(ns my-cloj-webapp.views
  (:require [my-cloj-webapp.controllers :as controllers]
            [hiccup.page :as hic-p]
            [compojure.route :as route]))


(defn home []
  (hic-p/html5
    [:form {:method "POST" :action "/"}
     [:p "Let's Get Started with our Link Shortening"]
     [:input {:type "text" :name "link"}]
     [:input {:type "submit"}]]))


(defn shortened-link [link] (controllers/get-link link))

  (defn shorten
    [params]
    (let [link (params :link)]
      (let [possible-link (controllers/set-link link)]
        (if (false? possible-link)
        "This is not a valid link."
        (str possible-link)))))
