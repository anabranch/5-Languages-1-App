(defproject my-cloj-webapp "0.1.0-SNAPSHOT"
  :description "An Extremely Simple Link-Shortening Service"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-defaults "0.1.2"]
                 [com.taoensso/carmine "2.9.0"]
                 [hiccup "1.0.5"]
                 [ring/ring-jetty-adapter "1.3.2"]]

  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler my-cloj-webapp.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
