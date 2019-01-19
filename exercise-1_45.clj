#!/usr/bin/env boot

(set-env! :dependencies '[[org.clojure/algo.generic "0.1.3"]])

(require '[clojure.algo.generic.math-functions :as math])

(defn repeated [f n]
  (defn- repeated-iter [g n]
    (if(= n 1) g
      (recur (fn [x] (f (g x))) (dec n))))
  (repeated-iter f n))

(defn square [x] (* x x))
(defn cube [x] (* x x x))
(defn pow [x n] ())

(defn avarage [x y]
  (/ (+ x y) 2))

(defn avarage-damp [f]
  (fn [x] (double (avarage x (f x)))))

(def tolerance 0.0000000001)

(defn fixed-point [f first-guess]
    (defn- close-enough? [v1 v2]
      (< (math/abs (- v1 v2)) tolerance))
    
    (defn- do-try [guess]
      (let [next-guess (f guess)]
        (if (close-enough? next-guess guess)
          guess
          (recur next-guess))))
    
    (do-try first-guess))

(defn pow [x n]
  (defn- iter [r x n]
    (cond 
      (= n 0) r
      (even? n) (recur r (square x) (/ n 2))
      :else     (recur (* r x) x (dec n))))
  
  (iter 1 x n))

(defn log2 [x]
  (/ (math/log x) (math/log 2)))

(defn get-number-of-repeats [x]
  (int (log2 x)))

(defn nth-root [n x]
  (fixed-point ((repeated avarage-damp (get-number-of-repeats n))
                (fn [y] (/ x (pow y (dec n))))) 1))

(defn -main [& args]
  (println (pow 2 5))
  (println (log2 4))
  (nth-root 2 8)
  (nth-root 9 2048)
  )
