(ns leiningen.new.codebrutale
  (:require
   [leiningen.new.templates :refer [renderer name-to-path ->files]]
   [leiningen.core.main :as main]))

(def render (renderer "codebrutale"))

(defn codebrutale
  "Generate a simple Clojure project"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (->files data
             ["src/codebrutale/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["project.clj" (render "project.clj" data)])))
