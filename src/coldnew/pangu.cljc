(ns coldnew.pangu
  (:require [coldnew.pangu.impl :as impl]
            #?(:clj  [clojure.test :refer [is]]
               :cljs [cljs.test :refer-macros [is]])))

(defn spacing
  "Performs a paranoid text spacing on str."
  [str]
  {:pre  [(is (string? str))]
   :post [(is (string? %))]}
  (->> str
       impl/spacing-quote
       impl/spacing-hash
       impl/spacing-operator
       impl/spacing-brackets
       impl/spacing-symbol
       impl/spacing-ans))
