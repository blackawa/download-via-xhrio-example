(defproject download-via-xhrio-example "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.6.1"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.stuartsierra/component "0.3.1"]
                 [compojure "1.5.1"]
                 [duct "0.8.2"]
                 [environ "1.1.0"]
                 [ring "1.5.0"]
                 [ring-jetty-component "0.3.1"]
                 [org.clojure/clojurescript "1.9.229"]
                 [org.clojure/core.async "0.2.391"
                  :exclusions [org.clojure/tools.reader]]]
  :plugins [[lein-figwheel "0.5.8"]
            [lein-cljsbuild "1.1.4" :exclusions [[org.clojure/clojure]]]]
  :source-paths ["src/clj"]
  :clean-targets ^{:protect false} ["resources/download_via_xhrio_example/public/js/compiled" "target"]
  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src/cljs"]
                :figwheel {:on-jsload "download-via-xhrio-example.core/on-js-reload"}
                :compiler {:main download-via-xhrio-example.core
                           :asset-path "js/compiled/out"
                           :output-to "resources/download_via_xhrio_example/public/js/compiled/app.js"
                           :output-dir "resources/download_via_xhrio_example/public/js/compiled/out"
                           :source-map-timestamp true
                           :preloads [devtools.preload]}}
               {:id "min"
                :source-paths ["src/cljs"]
                :compiler {:output-to "resources/download_via_xhrio_example/public/js/compiled/app.js"
                           :main download-via-xhrio-example.core
                           :optimizations :advanced
                           :pretty-print false}}]}
  :figwheel {:css-dirs ["resources/download_via_xhrio_example/public/css"]}
  :profiles {:dev {:dependencies [[duct/generate "0.8.2"]
                                  [reloaded.repl "0.2.3"]
                                  [org.clojure/tools.namespace "0.2.11"]
                                  [org.clojure/tools.nrepl "0.2.12"]
                                  [eftest "0.1.1"]
                                  [com.gearswithingears/shrubbery "0.4.1"]
                                  [kerodon "0.8.0"]
                                  ;; for figwheel
                                  [binaryage/devtools "0.8.2"]
                                  [figwheel-sidecar "0.5.8"]
                                  [com.cemerick/piggieback "0.2.1"]]
                   :source-paths ["dev/src"]
                   :resource-paths ["dev/resources"]
                   :repl-options {:port 54872
                                  :init-ns user
                                  :init (set! *print-length* 50)
                                  :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]
                                  :env {:port "3000"}}}})
