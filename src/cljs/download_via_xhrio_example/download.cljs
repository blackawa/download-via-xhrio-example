(ns download-via-xhrio-example.download
  (:require [download-via-xhrio-example.xhrio :refer [request]]
            [goog.dom :as dom]))

(defn- send-pdf-to-browser [binary file-name]
  (let [blob (js/Blob. (clj->js [binary]) (clj->js {"type" "application/pdf"}))
        url (.createObjectURL (.-URL js/window) blob)
        link (dom/createDom "a" (clj->js {"href" url}))]
    (dom/appendChild (.-body js/document) link)
    (set! (.-download link) file-name)
    (.click link)
    (dom/removeChildren link)))

(defn plain-text []
  (request "http://localhost:3000/api/download/plain-text"
           :get
           (fn [res] (send-pdf-to-browser res "plain-text.txt"))))

(defn image []
  (println "downloading image..."))

(defn pdf []
  (println "downloading pdf..."))
