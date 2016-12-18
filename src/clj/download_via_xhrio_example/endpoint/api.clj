(ns download-via-xhrio-example.endpoint.api
  (:require [clojure.java.io :as io]
            [compojure.core :refer :all]
            [liberator.core :refer [resource defresource]]
            [liberator.representation :refer [ring-response]]))

(defn- fetch-text []
  (ring-response (io/file (io/resource "download_via_xhrio_example/download/plain-text.txt"))
                 {:headers {"Content-Type" "text/plain; charset=utf-8"}}))
(defresource ^:private plain-text-resource []
  :allowed-methods [:get]
  :available-media-types ["*/*"]
  :handle-ok (fetch-text))

(defn- fetch-image []
  (ring-response (io/file (io/resource "download_via_xhrio_example/download/image.png"))
                 {:headers {"Content-Type" "image/png"}}))
(defresource ^:private image-resource []
  :allowed-methods [:get]
  :available-media-types ["*/*"]
  :handle-ok (fetch-image))

(defn- fetch-pdf []
  (ring-response (io/file (io/resource "download_via_xhrio_example/download/google.pdf"))
                 {:headers {"Content-Type" "application/pdf"}}))
(defresource ^:private pdf-resource []
  :allowed-methods [:get]
  :available-media-types ["*/*"]
  :handle-ok (fetch-pdf))

;; routes ------------------------------------------------------

(defn api-endpoint [_]
  (routes
   (context "/api" _
            (ANY "/download/plain-text" _ (plain-text-resource))
            (ANY "/download/image"      _ (image-resource))
            (ANY "/download/pdf"        _ (pdf-resource)))))
