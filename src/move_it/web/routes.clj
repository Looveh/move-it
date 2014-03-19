(ns move-it.web.routes
  (:require [compojure.core :refer [defroutes GET POST]]
            [compojure.route :refer [resources]]
            [ring.util.response :refer [redirect]]
            [move-it.web.controllers.offer :as offer]
            [move-it.web.controllers.price :as price]))

(defroutes routes
  (resources "/")
  (GET "/" [] (redirect "/offer/create"))
  (GET "/price/calculate" [] (price/calculate-get))
  (POST "/price/calculate" params (price/calculate-post params))
  (GET "/offer/create" [] (offer/create-get))
  (POST "/offer/create" params (offer/create-post params))
  (GET "/offer/show/:id" [id] (offer/show-get id)))


