#!/usr/bin/env boot

(set-env! :dependencies '[[org.clojure/algo.generic "0.1.3"]])

(require '[clojure.algo.generic.math-functions :as math])

(def tolerance 0.00001)

(defn fixed-point [f first-guess]
  (defn- close-enough? [v1 v2]
    (< (math/abs (- v1 v2)) tolerance))
  
  (defn- do-try [guess counter]
    (let [next-guess (f guess)]
      (if (close-enough? next-guess guess)
        (do (println (str "Counter: " counter))
            guess)
        (recur next-guess (inc counter)))))
  
  (do-try first-guess 1))

(defn average [x y]
  (/ (+ x y) 2))

(defn -main [& args]
  (defn- function [x] (/ (math/log 1000) (math/log x)))

  (println (double (fixed-point function 3)))
  (println (double (fixed-point (fn [x] (average x (function x))) 3))))
