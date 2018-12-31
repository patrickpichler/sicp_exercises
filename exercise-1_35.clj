#!/usr/bin/env boot

(set-env! :dependencies '[[org.clojure/algo.generic "0.1.3"]])

(require '[clojure.algo.generic.math-functions :as math])

(def tolerance 0.00001)

(defn fixed-point [f first-guess]
  (defn- close-enough? [v1 v2]
    (< (math/abs (- v1 v2)) tolerance))
  
  (defn- do-try [guess]
    (let [next-guess (f guess)]
      (if (close-enough? next-guess guess)
        guess
        (recur next-guess))))
  
  (do-try first-guess))

(defn -main [& args]
  (fixed-point (fn [x] (+ 1 (/ 1 x))) 1))
