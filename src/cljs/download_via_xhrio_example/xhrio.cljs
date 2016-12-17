(ns download-via-xhrio-example.xhrio
  (:require [clojure.browser.net :as net]
            [cljs.reader :refer [read-string]]
            [goog.events :as events]
            [goog.dom :as dom])
  (:import [goog.net EventType]))

(defn request
  "Send Asynchronous request via Xhrio"
  [url method handler & {:keys [body headers]}]
  (let [xhrio (net/xhr-connection)]
    (events/listen xhrio EventType.SUCCESS
                   (fn [e]
                     (let [res (.getResponseText xhrio)]
                       (handler res))))
    (.send xhrio
           url
           (.toLowerCase (name method))
           body
           (clj->js (merge headers {})))))
