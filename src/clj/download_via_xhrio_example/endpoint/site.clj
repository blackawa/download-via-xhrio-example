(ns download-via-xhrio-example.endpoint.site
  (:require [compojure.core :refer :all]
            [clojure.java.io :as io]))

(defn- site []
  (io/resource "download_via_xhrio_example/public/index.html"))

(defn site-endpoint [_]
  (routes
   (GET "/site" _ (site))))
