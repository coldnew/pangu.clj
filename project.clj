(defproject pangu "0.1.0-SNAPSHOT"
  :description "Paranoid text spacing in Clojure/ClojureScript."
  :url "https://github.com/coldnew/pangu.clj"
  :license {:name "MIT License"
            :url "https://github.com/coldnew/pangu.clj/blob/master/LICENSE"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.7.228"]]

  :source-paths ["src"]
  :test-paths ["spec"]

  :profiles {:dev {:dependencies [[speclj "3.3.1"]]}}
  :plugins [[speclj "3.3.1"]
            [lein-codox "0.9.4"]
            [lein-cljsbuild "1.1.2"]]

  :cljsbuild {:builds {:dev  {:source-paths ["src" "spec"]
                              :compiler     {:output-to "target/pangu.js"
                                             :optimizations :simple}
                              :notify-command ["phantomjs" "bin/speclj" "target/pangu.js"]}
                       :prod {:source-paths  ["src"]
                              :compiler      {:output-to "target/pangu.js"
                                              :optimizations :simple}}}
              :test-commands {"test" ["phantomjs"  "bin/speclj" "target/pangu.js"]}}

  :codox {:source-uri "https://github.com/coldnew/pangu.clj/blob/master/{filepath}#L{line}"})
