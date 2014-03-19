(ns move-it.web.views.price
  (:require [hiccup.page :refer [html5]]
            [hiccup.form :refer :all]))

(defn calculate []
  (html5 
    (form-to [:post "/price/calculate"]
             (label "distance" "Distance:")
             (text-field "distance")
             [:br]
             (label "residential-area" "Residential area")
             (text-field "residential-area")
             [:br]
             (label "basement-area" "Basement area:")
             (text-field "basement-area")
             [:br]
             (label "piano" "Piano: ")
             (check-box "piano")
             [:br]
             (label "pack-help" "Packhjälp: ")
             (check-box "pack-help")
             [:br]
             (submit-button "Submit"))))
