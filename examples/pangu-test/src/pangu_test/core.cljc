(ns pangu-test.core
  (:require [coldnew.pangu :as pangu]))

;; enable *print-fn* in clojurescript
#?(:cljs (enable-console-print!))

(defn- test-text []
  "Mr.龍島主道：「Let's Party!各位高明博雅君子！」")

(defn -main [& args]
  (println (str "Origin str: " (test-text)))
  (println (str "Pangu-Spacing: " (pangu/spacing (test-text)))))

;; setup node.js starter point
#?(:cljs (set! *main-cli-fn* -main))
