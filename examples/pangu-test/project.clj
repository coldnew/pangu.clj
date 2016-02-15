(defproject pangu-test "0.1.0-SNAPSHOT"
  :description "Simple example for pangu.clj"
  :author "Yen-Chin, Lee"
  :url "https://github.com/coldnew/pangu.clj"
  :license {:name "MIT License"
            :url "https://github.com/coldnew/pangu.clj/blob/master/LICENSE"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [coldnew/pangu "1.0.0"]]

  :cljsbuild {:builds {:dev  {:source-paths ["src"]
                              :compiler     {:target :nodejs
                                             :output-to "target/pangu-test.js"
                                             :optimizations :simple}}
                       :prod {:source-paths  ["src"]
                              :compiler      {:target :nodejs
                                              :output-to "target/pangu-test.js"
                                              :optimizations :advanced}}}})
