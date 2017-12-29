(ns leiningen.new.lein-template
  (:require
   [leiningen.new.templates :refer [renderer name-to-path ->files]]
   [leiningen.core.main :as main]))

(def render (renderer "lein-template"))

(defn lein-template
  "Generate a simple Clojure project"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' codebrutale/lein-template project.")
    (->files data
             ["src/codebrutale/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["project.clj" (render "project.clj" data)])))
