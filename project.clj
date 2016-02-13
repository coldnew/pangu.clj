(defproject pangu "0.1.0-SNAPSHOT"
  :description "Paranoid text spacing in Clojure/ClojureScript."
  :url "https://github.com/coldnew/pangu.clj"
  :license {:name "MIT License"
            :url "https://github.com/coldnew/pangu.clj/blob/master/LICENSE"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :test-paths ["spec"]
  :profiles {:dev {:dependencies [[speclj "3.3.0"]]}}
  :plugins [[speclj "3.3.0"]
            [lein-codox "0.9.4"]])
