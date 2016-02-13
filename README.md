# Pangu.clj
[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/coldnew/pangu.clj/master/LICENSE)
[![Circle CI](https://circleci.com/gh/coldnew/pangu.clj.svg?style=svg)](https://circleci.com/gh/coldnew/pangu.clj)
[![Dependencies Status](https://jarkeeper.com/coldnew/pangu.clj/status.svg)](https://jarkeeper.com/coldnew/pangu.clj)
[![Downloads](https://jarkeeper.com/coldnew/pangu.clj/downloads.svg)](https://jarkeeper.com/coldnew/pangu.clj)

Paranoid text spacing for good readability, to automatically insert whitespace between CJK (Chinese, Japanese, Korean), half-width English, digit and symbol characters.

This library is designed for **both** Clojure/ClojureSript, you need minimal clojure version **1.7.0**

* [pangu.go](https://github.com/vinta/pangu) (Go)
* [pangu.java](https://github.com/vinta/pangu.java) (Java)
* [pangu.js](https://github.com/vinta/paranoid-auto-spacing) (JavaScript, both Node.js and Browser)
* [pangu.py](https://github.com/vinta/pangu.py) (Python)
* [pangu.rb](https://github.com/dlackty/pangu.rb) (Ruby)
* [pangu.objective-c](https://github.com/Cee/pangu.objective-c) (Objective-C)
* [pangu.php](https://github.com/Kunr/pangu.php) (PHP)

## Usage

```clojure
(ns pangu-test.core
  (:require [coldnew.pangu :as pangu]))

(defn -main []
  (println (pangu/spacing "請問Jackie的鼻子有幾個？123個！"))) ; => "請問 Jackie 的鼻子有幾個？123 個！"

```

## License

Copyright © 2016 Yen-Chin, Lee <<coldnew.tw@gmail.com>>

Distributed under the MIT License.
