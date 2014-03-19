(ns move-it.web.server
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.params :refer [wrap-params]]
            [move-it.web.routes :refer [routes]]))

(defn -main []
  (run-jetty (wrap-params routes) {:port 4321 :join? false}))

