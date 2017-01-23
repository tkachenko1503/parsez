(ns parsez.core
  (:gen-class)
  (:require [instaparse.core :as insta :refer [defparser]]))

(defparser html-parser "resources/html_grammar.txt")

(defn -main
  "Parse html document into clojure data"
  [html-file-path]
  (let [html (slurp html-file-path)]
    (html-parser html)))

(let [res (-main "test/test_html/simple_tags.html")
      err (insta/get-failure res)]
  (or err res))
