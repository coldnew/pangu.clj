(ns coldnew.pangu
  (:require [coldnew.pangu.impl :as impl]))

(defn ^:export spacing
  "Performs a paranoid text spacing on str."
  [str]
  (->> str
       impl/spacing-quote
       impl/spacing-hash
       impl/spacing-operator
       impl/spacing-brackets
       impl/spacing-symbol
       impl/spacing-ans))
