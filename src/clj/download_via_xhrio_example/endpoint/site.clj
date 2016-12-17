(ns download-via-xhrio-example.endpoint.site
  (:require [compojure.core :refer :all]
            [clojure.java.io :as io]
            [download-via-xhrio-example.view :refer [site-view]]
            [download-via-xhrio-example.style :refer [style]]))

(defn- site []
  (site-view))

(defn- fetch-style []
  {:body (style)
   :headers {"Content-Type" "text/css;charset=utf-8"}})

(defn site-endpoint [_]
  (routes
   (GET "/site" _ (site))
   (GET "/css/style.css" _ (fetch-style))))
