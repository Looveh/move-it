(ns move-it.core.repository
  (:require [monger.core :refer [connect! set-db! get-db]]
            [monger.collection :refer [insert-and-return find-one]]
            [clojure.walk :refer [keywordize-keys]]
            [move-it.core.price :refer :all])
  (:import [org.bson.types ObjectId]
           [com.mongodb DB WriteConcern]))

(def collection "offers")

(defn- BasicDBObject->hash-map [offer]
  (clojure.walk/keywordize-keys  
    (reduce merge 
            (map #(hash-map  
                    (.getKey %1)  
                    (.getValue %1))  
                 (.entrySet offer)))))

(connect!)
(set-db! (get-db "move-it"))

(defn save-offer [offer]
  (let [offer (BasicDBObject->hash-map offer)
        price (get-price offer)]
    (insert-and-return collection (assoc offer :price price))))

(defn get-offer [id]
  (BasicDBObject->hash-map (find-one collection {:_id (ObjectId. id)})))

