#!/usr/bin/env boot

(defn gcd [a b]
  (if (= b 0) a
    (recur b (mod a b))))

(defn normalize-sign [n d]
  (cond (and (< n 0) (< d 0)) (list n d)
        (< n 0) (list n d)
        (< d 0) (list (- n) (- d))
        :else (list n d)))

(defn make-rat [n d] 
  (let [[norm-n norm-d] (normalize-sign n d)
        g (gcd norm-n norm-d)]
    (list (/ norm-n g) (/ norm-d g))))

(defn numer [x] (first x))

(defn denom [x] (last x))

(defn print-rat [x] 
  (println (str (numer x) "/" (denom x))))

(defn -main [& args]
  (println "hello world"))
