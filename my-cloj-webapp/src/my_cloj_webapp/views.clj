(ns my-cloj-webapp.views
  (:require [my-cloj-webapp.controllers :as controllers]
            [hiccup.page :as hic-p]
            [hiccup.element :as hic-el]
            [compojure.route :as route]))

(defn gen-headers []
  [:head [:link {:rel "stylesheet"
                 :href "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"}]
   [:link {:rel "stylesheet"
           :href "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"}]
   [:script "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"]
   (hic-p/include-css "/main.css")]
  )

(defn gen-shorten-form []
  [:form {:method "POST" :action "/"}
   [:div {:class "form-group"}
    [:label {:for "link"} "Please Enter a url"]
    [:input {:type "url" :name "link" :id "link"
             :class "form-control" :placeholder "https://www.google.com"}]]
   [:button {:type "submit" :class "btn btn-success"} "Submit"]]
  )

(defn gen-row [& more] [:div {:class "row"} more])

(defn gen-row-item
  ([size inner]
    [:div {:class (str "col-md-" size)} inner])
  ([size offset inner]
    [:div {:class (str "col-md-" size " col-md-offset-" offset)} inner]))

(defn gen-container [& more]
  [:div {:class "container"} more])


(defn gen-generic-page [& content]
  (hic-p/html5
    (gen-headers)
    (gen-container
      (gen-row [:div {:class "buffer"}])
      content)))

(defn home []
  (gen-generic-page
    (gen-row
      (gen-row-item 4 4
        (gen-shorten-form)))))


(defn shortened-link [link] (controllers/get-link link))

;TODO: Likely opportunity for a refactor

(defn gen-shorten-success [original short]
  (gen-generic-page
    (gen-row
      (gen-row-item 4 4 [:p short]))
    (gen-row
      (gen-row-item 4 4 (hic-el/link-to original "Original")))))

(defn gen-shorten-failure [original]
  (gen-generic-page
    (gen-row
      (gen-row-item 4 4 [:p "Sorry, that's not a valid link, please try again"]))
    (gen-row
      (gen-row-item 4 4 (gen-shorten-form)))))

(defn shorten
  [params]
  (let
    [link (params :link) possible-link (controllers/set-link link)]
    (if (false? possible-link)
      (gen-shorten-failure link)
      (gen-shorten-success link possible-link))))
