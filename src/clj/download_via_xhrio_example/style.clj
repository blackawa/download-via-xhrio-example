(ns download-via-xhrio-example.style
  (:require [garden.core :refer [css]]))

(defn style []
  (css [:html
        [:h2 {:text-align "center"
              :color "#4e1"}]
        [:div.buttons {:text-align "center"}]]))
