#!/usr/bin/env boot

(set-env! :dependencies '[[org.clojure/algo.generic "0.1.3"]])

(require '[clojure.algo.generic.math-functions :as math])

(defn iterative-improve [good-enough? improve]
  (defn- iter [guess]
    (let [next-guess (improve guess)]
      (if (good-enough? guess next-guess) next-guess
        (recur next-guess))))
  
  (fn [initial-guess] (iter initial-guess)))

(defn average [x y]
  (/ (+ x y) 2))

(defn average-damp [f]
  (fn [x] (double (average x (f x)))))

(def tolerance 0.00001)

(defn fixed-point [f guess]
  (defn- good-enough? [guess next-guess]
    (< (math/abs (- guess next-guess)) tolerance))

  ((iterative-improve good-enough? f) guess))

(defn square [x] (* x x))

(defn sqrt-1-1-7 [x]
  (defn- improve [guess x]
    (average guess (/ x guess)))

  (defn- good-enough? [guess x]
    (< (math/abs (- (square guess) x)) tolerance))

  (defn- iter [guess x]
    (if (good-enough? guess x) guess
      (recur (improve guess x) x)))
  
  (iter 1.0 x))

(defn sqrt [x]
  (defn- improve [guess]
    (average guess (/ x guess)))
  
  (defn- good-enough? [guess new-guess]
    (< (math/abs (- (square guess) x)) tolerance))
  
  ((iterative-improve good-enough? improve) 1.0))

(defn -main [& args]
  (println (sqrt-1-1-7 4))
  (println (sqrt 4))
  )
