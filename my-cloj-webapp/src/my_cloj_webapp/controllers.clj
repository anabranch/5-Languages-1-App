(ns my-cloj-webapp.controllers)

(def hash-links (atom {}))

(defn hash-link [link] (str (hash link)))

(defn get-link
  [shortened-link]
  (@hash-links (name shortened-link)))

(defn check-db-link
  [shortened-link]
  ((complement nil?) (get-link shortened-link)))


(defn set-link
  [link]
  (let [hashed-link (hash-link link)]
    (swap! hash-links assoc hashed-link link)
    hashed-link)
  )

(defn get-and-set-link
  [potential-link]
  (if  (check-db-link potential-link)
    (get-link potential-link)
    (set-link potential-link))
  )