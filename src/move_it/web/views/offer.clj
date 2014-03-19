(ns move-it.web.views.offer
  (:require [hiccup.page :refer [html5 include-css]]
            [hiccup.form :refer :all]
            [hiccup.def :refer [defhtml]]))

(defn- ja-nej [b]
  (if b "Ja" "Nej"))

(defhtml layout [& body]
  [:head
   [:title "MoveIT"]
   (include-css "/style.css")]
  (into [:body] body))

(defn create []
  (layout
    (form-to [:post "/offer/create"]
             [:div 
              (label "name" "Namn: ")
              [:br]
              (text-field "name")]
             [:div 
              (label "email" "Email: ")
              [:br]
              (text-field "email")] 
             [:div 
              (label "from" "Från: ")
              [:br]
              (text-field "from")] 
             [:div 
              (label "to" "Till: ")
              [:br]
              (text-field "to")] 
             [:div 
              (label "distance" "Avstånd: ")
              [:br]
              (text-field "distance")] 
             [:div 
              (label "residential-area" "Bostadens yta: ")
              [:br]
              (text-field "residential-area") ] 
             [:div 
              (label "basement-area" "Vind/källares yta: ")
              [:br]
              (text-field "basement-area") ] 
             [:div 
              (label "piano" "Piano: ")
              (check-box "piano") ] 
             [:div 
              (label "pack-help" "Packhjälp: ")
              (check-box "pack-help") ] 
             (submit-button "Submit"))))

(defn show [offer]
  (layout
    [:h1 "Prisförslag för bohagsflytt"]
    [:div {:style "float: left; width: 400px"}
     [:div {:class "section"}
      "Offertnummer: " (:_id offer)]
     [:div {:class "section"}
      [:div 
       (label "person-name" "Namn: ")
       (:name offer)]
      [:div 
       (label "email" "Email: ")
       (:email offer)]]
     [:div {:class "section"}
      [:div 
       (label "from" "Från: ")
       (:from offer)] 
      [:div 
       (label "to" "Till: ")
       (:to offer)] 
      [:div 
       (label "distance" "Avstånd: ")
       (:distance offer) " km"]]
     [:div {:class "section"}
      [:div 
       (label "residential-area" "Bostadens yta: ")
       (:residential-area offer) " kvm"] 
      [:div 
       (label "basement-area" "Vind/källares yta: ")
       (:basement-area offer) " kvm"]]
     [:div {:class "section"}
      [:div
       "Övrigt"]
      [:div 
       (label "piano" "Piano: ")
       (ja-nej (:piano offer))] 
      [:div 
       (label "pack-help" "Packhjälp: ")
       (ja-nej (:pack-help offer))]]]
    [:div {:style "float: left; width: 400px"}
     [:div {:class "section"}
      [:h2
       "Uppskattat pris:" [:br]
       (:price offer) " kr"]] 
     [:div {:class "section"}
      "Vi sparar ditt prisförslag i 90 dagar." [:br]
      "För att se prisförslaget igen, besök: " [:br]
      (let [link (str "http://localhost:4321/offer/show/" (:_id offer))]
        [:a {:href link} link])]
     [:div {:class "section"}
      "Om du har frågor, kontakta" [:br]
      "flytt@moveit.se"]]))
