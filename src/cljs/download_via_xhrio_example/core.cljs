(ns download-via-xhrio-example.core
  (:require [download-via-xhrio-example.download :as download]))

(enable-console-print!)

(defn- add-event-listener [dom-id callback-fn]
  (.addEventListener (js/document.getElementById dom-id)
                     "click"
                     callback-fn))

(defn- remove-event-listener [dom-id callback-fn]
  (.removeEventListener (js/document.getElementById dom-id)
                        "click"
                        callback-fn))

(add-event-listener "plain-text" download/plain-text)
(add-event-listener "image" download/image)
(add-event-listener "pdf" download/pdf)

;; remove event listener before reload js ----------------
(defn before-js-reload []
  (remove-event-listener "plain-text" download/plain-text)
  (remove-event-listener "image" download/image)
  (remove-event-listener "pdf" download/pdf))
