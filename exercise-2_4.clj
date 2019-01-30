#!/usr/bin/env boot

(defn my-cons [x y] (fn [m] (m x y)))

(defn car [z] (z (fn [p q] p)))
(defn cdr [z] (z (fn [p q] q)))

(def test-cons (my-cons 1 2))

(println (car test-cons))
(println (cdr test-cons))

(defn -main [& args]
  (println "hello world"))
