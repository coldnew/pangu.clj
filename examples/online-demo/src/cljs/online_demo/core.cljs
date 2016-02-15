(ns online-demo.core
  (:require [coldnew.pangu :as pangu]
            [goog.dom      :as gdom]
            [om.next       :as om   :refer-macros [defui]]
            [sablono.core  :as html :refer-macros [html]]
            ;; codemirror and it's friends
            [cljsjs.codemirror]))

(enable-console-print!)


(defui MainWindow
  Object
  (render [this]
          (html
           [:div.container
            [:h1 "test"]
            ])))


(def mainwin (om/factory MainWindow))

;; init
(js/ReactDOM.render
   (mainwin {})
   (gdom/getElement "app"))
