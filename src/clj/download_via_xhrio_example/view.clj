(ns download-via-xhrio-example.view
  (:require [hiccup.page :refer [html5 include-css include-js]]))

(defn site-view []
  (html5
   [:head
    [:meta {:charset "utf-8"}]
    (include-css "css/style.css")]
   [:body
    [:div {:id "app"}
     [:h2 "Download Files via Asynchronous XMLHttpRequests with " [:b "Xhrio"]]
     [:div.buttons
      [:button
       {:type "submit"
        :id "plain-text"}
       "Download plain text"]
      [:button
       {:type "submit"
        :id "image"}
       "Download image file"]
      [:button
       {:type "submit"
        :id "pdf"}
       "Download pdf file"]]]
    (include-js "js/compiled/app.js")]))
