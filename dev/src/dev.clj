(ns dev
  (:refer-clojure :exclude [test])
  (:require [clojure.repl :refer :all]
            [clojure.pprint :refer [pprint]]
            [clojure.tools.namespace.repl :refer [refresh]]
            [clojure.java.io :as io]
            [com.stuartsierra.component :as component]
            [duct.generate :as gen]
            [duct.util.repl :refer [setup test migrate rollback]]
            [duct.util.system :refer [load-system]]
            [reloaded.repl :refer [system init start stop go reset]]
            ;; for figwheel
            [figwheel-sidecar.repl-api :as f]))

(defn new-system []
  (load-system (keep io/resource ["download_via_xhrio_example/system.edn" "dev.edn" "local.edn"])))

(when (io/resource "local.clj")
  (load "local"))

(gen/set-ns-prefix 'hoge-example)

(reloaded.repl/set-init! new-system)

;; --- for figwheel ---------------

(defn fig-start []
  (f/start-figwheel!))

(defn fig-stop []
  (f/stop-figwheel!))

(defn cljs-repl []
  (f/cljs-repl))
