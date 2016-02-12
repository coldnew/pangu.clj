(ns coldnew.pangu.core
  (:require [clojure.string :as str]))


;; \u2e80-\u2eff CJK Radicals Supplement
;; \u2f00-\u2fdf Kangxi Radicals
;; \u3040-\u309f Hiragana
;; \U30a0-\u30ff Katakana
;; \u3100-\u312f Bopomofo
;; \u3200-\u32ff Enclosed CJK Letters and Months
;; \u3400-\u4dbf CJK Unified Ideographs Extension A
;; \u4e00-\u9fff CJK Unified Ideographs
;; \uf900-\ufaff CJK Compatibility Ideographs
;;
;; http://unicode-table.com/en/
;; https://github.com/vinta/pangu

(defn- cjk-quote [str]
  (let [RE #"([\u2e80-\u2eff\u2f00-\u2fdf\u3040-\u309f\u30a0-\u30ff\u3100-\u312f\u3200-\u32ff\u3400-\u4dbf\u4e00-\u9fff\uf900-\ufaff])([\"])"]
    (str/replace str RE "$1 $2")))

(defn- quote-cjk [str]
  (let [RE #"([\"'])([\u3040-\u312f\u3200-\u32ff\u3400-\u4dbf\u4e00-\u9fff\uf900-\ufaff])"]
    (str/replace str RE "$1 $2")))

(defn- fix-quote [str]
  (let [RE (re-pattern "([\"'\\(\\[\\{<\u201c]+)(\\s*)(.+?)(\\s*)([\"'\\)\\]\\}>\u201d]+)")]
    (str/replace str RE "$1$3$5")))

(defn- fix-single-quote [str]
  (let [RE #"([\u2e80-\u2eff\u2f00-\u2fdf\u3040-\u309f\u30a0-\u30ff\u3100-\u312f\u3200-\u32ff\u3400-\u4dbf\u4e00-\u9fff\uf900-\ufaff])( )(')([A-Za-z])"]
    (str/replace str RE "$1$3$4")))

(defn- cjk-hash [str]
  (let [RE #"([\u2e80-\u2eff\u2f00-\u2fdf\u3040-\u309f\u30a0-\u30ff\u3100-\u312f\u3200-\u32ff\u3400-\u4dbf\u4e00-\u9fff\uf900-\ufaff])(#(\\S+))"]
    (str/replace str RE "$1 $2")))

(defn- hash-cjk [str]
  (let [RE #"((\\S+)#)([\u2e80-\u2eff\u2f00-\u2fdf\u3040-\u309f\u30a0-\u30ff\u3100-\u312f\u3200-\u32ff\u3400-\u4dbf\u4e00-\u9fff\uf900-\ufaff])"]
    (str/replace str RE "$1 $3")))

(defn- cjk-operator [str]
  (let [RE #"([\u2e80-\u2eff\u2f00-\u2fdf\u3040-\u309f\u30a0-\u30ff\u3100-\u312f\u3200-\u32ff\u3400-\u4dbf\u4e00-\u9fff\uf900-\ufaff])([\+-\\*/=&\\\\|<>])([A-Za-z0-9])"]
    (str/replace str RE "$1 $2 $3")))

(defn- operator-cjk [str]
  (let [RE #"([A-Za-z0-9])([\+-\\*/=&\\\\|<>])([\u2e80-\u2eff\u2f00-\u2fdf\u3040-\u309f\u30a0-\u30ff\u3100-\u312f\u3200-\u32ff\u3400-\u4dbf\u4e00-\u9fff\uf900-\ufaff])"]
    (str/replace str RE "$1 $2 $3")))

(defn- cjk-bracket-cjk [str]
  (let [RE #"([\u2e80-\u2eff\u2f00-\u2fdf\u3040-\u309f\u30a0-\u30ff\u3100-\u312f\u3200-\u32ff\u3400-\u4dbf\u4e00-\u9fff\uf900-\ufaff])([\(\[\{<\u201c]+(.*?)[\)\]\}>\u201d]+)([\u2e80-\u2eff\u2f00-\u2fdf\u3040-\u309f\u30a0-\u30ff\u3100-\u312f\u3200-\u32ff\u3400-\u4dbf\u4e00-\u9fff\uf900-\ufaff])"]
    (str/replace str RE "$1 $2 $4")))

(defn- cjk-bracket [str]
  (let [RE #"([\u2e80-\u2eff\u2f00-\u2fdf\u3040-\u309f\u30a0-\u30ff\u3100-\u312f\u3200-\u32ff\u3400-\u4dbf\u4e00-\u9fff\uf900-\ufaff])([\(\[\{<\u201c>])"]
    (str/replace str RE "$1 $2")))

(str/replace "a+-*/ ( " #"\(" "A")


(defn spacing [str]
  (->> str
       ;; quote
       cjk-quote
       quote-cjk
       fix-quote
       fix-single-quote
       ;;
       cjk-hash
       hash-cjk
       ;;
       cjk-operator
       operator-cjk
       ;;
       cjk-bracket-cjk
       ))

;; (= (spacing "前面\"中文123漢字\"後面") "前面 \"中文 123 漢字\" 後面")
(spacing "前面\"中文123漢字\"後面")
