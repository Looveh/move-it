(ns move-it.web.controllers.offer
  (:require [ring.util.response :refer [redirect]]
            [move-it.core.price-service :refer :all]
            [move-it.web.views.offer :as views]
            [move-it.core.repository :refer [save-offer get-offer]]))

(defn show-get [id]
  (views/show (get-offer id)))

(defn create-get []
  (views/create))

(defn create-post [offer]
  (let [offer (clojure.walk/keywordize-keys (:form-params offer))]
    (if (valid? offer)
      (redirect (str "/offer/show/" (:_id (save-offer (parse offer))))) 
      (redirect "/offer/create"))))

