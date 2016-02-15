# Pangu.clj
[![Circle CI](https://circleci.com/gh/coldnew/pangu.clj.svg?style=svg)](https://circleci.com/gh/coldnew/pangu.clj)
[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/coldnew/pangu.clj/master/LICENSE)


Paranoid text spacing for good readability, to automatically insert whitespace between CJK (Chinese, Japanese, Korean), half-width English, digit and symbol characters.

[![Clojars Project](http://clojars.org/coldnew/pangu/latest-version.svg)](http://clojars.org/coldnew/pangu)

[Latest codox API docs](https://coldnew.github.io/pangu.clj/).

## Dependencies

This library is designed for **both** Clojure/ClojureSript, you need following minimal version:

* Clojure 1.7.0 ↑
* ClojureScript 1.7.0 ↑

## Usage

```clojure
(ns pangu-test.core
  (:require [coldnew.pangu :as pangu]))

(defn -main []
  (println (pangu/spacing "請問Jackie的鼻子有幾個？123個！"))) ; => "請問 Jackie 的鼻子有幾個？123 個！"

```

## Testing

This library test with [speclj](https://github.com/slagyr/speclj), to test with Clojure, use following command:

```
$ lein spec
```

If you want to test in ClojureScript, use below

```
$ lein cljsbuild test
```

## Related Projects

* [pangu.js](https://github.com/vinta/pangu.js) (JavaScript, both Node.js and Browser)
* [pangu.go](https://github.com/vinta/pangu) (Go)
* [pangu.java](https://github.com/vinta/pangu.java) (Java)
* [pangu.py](https://github.com/vinta/pangu.py) (Python)
* [pangu.rb](https://github.com/dlackty/pangu.rb) (Ruby)
* [pangu.objective-c](https://github.com/Cee/pangu.objective-c) (Objective-C)
* [pangu.php](https://github.com/Kunr/pangu.php) (PHP)
* [pangu.ex](https://github.com/cataska/pangu.ex) (Elixir)

## License

Copyright © 2016 Yen-Chin, Lee <<coldnew.tw@gmail.com>>

Distributed under the [MIT License](http://opensource.org/licenses/MIT).
