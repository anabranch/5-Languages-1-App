(ns my-cloj-webapp.controllers-test
  (:require [my-cloj-webapp.controllers :as cntrlr]
            [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [my-cloj-webapp.handler :refer :all]))

(deftest test-get-set
  (testing "Test Create, Get, and Check"
    (cntrlr/set-link "red")
    (cntrlr/set-link "blue")
    (let [hash-red (cntrlr/hash-link "red")]
      (is (= "red" (cntrlr/get-link hash-red)))
      )

    (let [hash-blue (cntrlr/hash-link "blue")]
      (is (= "blue" (cntrlr/get-link hash-blue)))
      (is (= hash-blue (cntrlr/set-link "blue")))
      )
    (is (= false (cntrlr/check-db-link "shoe")))
    )

  (testing "Test Get and Set Link"
    (let [hash-red (cntrlr/get-and-set-link "red")]
      (is (= (cntrlr/get-link hash-red) "red"))
      )
    )
  )
