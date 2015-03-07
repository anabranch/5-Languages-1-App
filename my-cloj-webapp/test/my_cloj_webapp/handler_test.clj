(ns my-cloj-webapp.handler-test
  (:require [my-cloj-webapp.handler :as handler]
            [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [my-cloj-webapp.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))))

  (testing "create"
    (def google-hash "-431156368")
    (def google-url "http://www.google.com")
    (let [response (app (mock/request :post "/" {:link google-url}))]
      (is (= (:status response) 200))
      (is (= (:body response) google-hash))))

  (testing "get"
    (def google-hash "-431156368")
    (def google-url "http://www.google.com")
    (let [response (app (mock/request :get (str "/" google-hash)))]
      (is (= (:status response) 200))
      (is (= (:body response) google-url))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
