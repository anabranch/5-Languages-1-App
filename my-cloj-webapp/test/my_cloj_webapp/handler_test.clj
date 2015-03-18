(ns my-cloj-webapp.handler-test
  (:require [my-cloj-webapp.handler :as handler]
            [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [my-cloj-webapp.handler :refer :all]))


(def google-resp "<!DOCTYPE html>\n<html><head><link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css\" rel=\"stylesheet\"><link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css\" rel=\"stylesheet\"><script>https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js</script><link href=\"/main.css\" rel=\"stylesheet\" type=\"text/css\"></head><div class=\"container\"><div class=\"row\"><div class=\"buffer\"></div></div><div class=\"row\"><div class=\"col-md-6 col-md-offset-3\"><h3>Here's your shortened link!</h3><pre><a href=\"-431156368\">-431156368</a></pre></div></div><div class=\"row\"><div class=\"col-md-6 col-md-offset-3\"><h3>This is the link we shortened!</h3><pre><a href=\"http://www.google.com\">http://www.google.com</a></pre></div></div><div class=\"row\"><div class=\"col-md-6 col-md-offset-3\"><h3>Shorten Another!</h3></div></div><div class=\"row\"><div class=\"col-md-4 col-md-offset-4\"><form action=\"/\" method=\"POST\"><div class=\"form-group\"><label for=\"link\">Enter a URL to Get a Shortened Link</label><input class=\"form-control\" id=\"link\" name=\"link\" placeholder=\"https://www.google.com\" type=\"url\"></div><button class=\"btn btn-success\" type=\"submit\">Shorten It!</button></form></div></div></div></html>")


(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))))

  (testing "create"
    (def google-hash "-431156368")
    (def google-url "http://www.google.com")
    (let [response (app (mock/request :post "/" {:link google-url}))]
      (is (= (:status response) 200))
      (is (= (:body response) google-resp))))

  (testing "get"
    (def google-hash "-431156368")
    (def google-url "http://www.google.com")
    (let [response (app (mock/request :get (str "/" google-hash)))]
      (is (= (:status response) 302))
      ))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
