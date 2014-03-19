(ns move-it.web.controllers.price
  (:require [move-it.web.views.price :as views]
            [move-it.core.price :refer [get-price]]
            [move-it.core.price-service :refer [valid? parse]]))

(defn calculate-get []
  (views/calculate))

(defn calculate-post [input]
  (let [input (clojure.walk/keywordize-keys (:form-params input))]
    (if (valid? input)
      (str (get-price (parse input))) 
      (str 0))))
