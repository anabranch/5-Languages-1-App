(ns my-cloj-webapp.views
  (:require [my-cloj-webapp.controllers :as controllers]
            [hiccup.page :as hic-p]
            [hiccup.element :as hic-el]
            [compojure.route :as route]
            [ring.util.response :as ring-resp]))


(def local-url (System/getenv "cljappurl"))

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
    [:label {:for "link"} "Enter a URL to Get a Shortened Link"]
    [:input {:type "url" :name "link" :id "link"
             :class "form-control" :placeholder "https://www.google.com"}]]
   [:button {:type "submit" :class "btn btn-success"} "Shorten It!"]]
  )

(defn gen-row [& more] [:div {:class "row"} more])

(defn gen-row-item
  ([size inner]
    [:div {:class (str "col-md-" size)} inner]))

(defn gen-row-item-offset
  ([size offset & contents]
    [:div {:class (str "col-md-" size " col-md-offset-" offset)} contents]))

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
      (gen-row-item-offset 4 4
        (gen-shorten-form)))))


(defn shortened-link [link] (ring-resp/redirect (controllers/get-link link)))

;TODO: Likely opportunity for a refactor

(defn gen-shorten-success [original short]
  (gen-generic-page
    (gen-row
      (let [built-link (str local-url short)]
        (gen-row-item-offset 6 3
          [:h3 "Here's your shortened link!"]
          [:pre (hic-el/link-to built-link built-link)])))
    (gen-row
      (gen-row-item-offset 6 3
        [:h3 "This is the link we shortened!"]
        [:pre (hic-el/link-to original original)]))
    (gen-row
      (gen-row-item-offset 6 3 [:h3 "Shorten Another!"]))
    (gen-row
      (gen-row-item-offset 4 4 (gen-shorten-form)))))

(defn gen-shorten-failure [original]
  (gen-generic-page
    (gen-row
      (gen-row-item-offset 4 4 [:p "Sorry, that's not a valid link, please try again"]))
    (gen-row
      (gen-row-item-offset 4 4 (gen-shorten-form)))))

(defn shorten
  [params]
  (let
    [link (params :link) possible-link (controllers/set-link link)]
    (if (false? possible-link)
      (gen-shorten-failure link)
      (gen-shorten-success link possible-link))))
