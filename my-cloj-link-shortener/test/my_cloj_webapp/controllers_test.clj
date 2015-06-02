(ns my-cloj-webapp.controllers-test
  (:require [my-cloj-webapp.controllers :as cntrlr]
            [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [my-cloj-webapp.handler :refer :all]))

(deftest test-get-set
  (testing "Test Create, Get, and Check"
    (def goog "http://www.google.com")
    (def chicken "http://chicken.org")
    (cntrlr/set-link goog)
    (cntrlr/set-link chicken)
    (let [hash-red (cntrlr/hash-link goog)]
      (is (= goog (cntrlr/get-link hash-red)))
      )

    (let [hash-blue (cntrlr/hash-link chicken)]
      (is (= chicken (cntrlr/get-link hash-blue)))
      (is (= hash-blue (cntrlr/set-link chicken)))
      )
    )
  )

(deftest test-url-Validator
  (testing "Url Validation"
    (is (= true (cntrlr/validate-url "http://www.google.com")))
    (is (= true (cntrlr/validate-url "https://www.google.com")))
    (is (= true (cntrlr/validate-url "https://google.com")))
    (is (= false (cntrlr/validate-url "google.org")))
    (is (= false (cntrlr/validate-url "http://chicken")))
    (is (= false (cntrlr/validate-url "chicken")))
    (is (= false (cntrlr/validate-url "http://.")))
    (is (= false (cntrlr/validate-url "http://")))
    ))
