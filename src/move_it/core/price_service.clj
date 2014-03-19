(ns move-it.core.price-service)

(defn- can-parse-to-int? [s]
  (not (nil? (re-matches #"\d+" s))))

(defn valid? [offer]
  (some true?
        [(can-parse-to-int? (:distance offer))
         (can-parse-to-int? (:basement-area offer))
         (can-parse-to-int? (:residential-area offer))]))

(defn parse [offer]
  (assoc offer 
         :distance (read-string (:distance offer))
         :basement-area (read-string (:basement-area offer))
         :residential-area (read-string (:residential-area offer))))
