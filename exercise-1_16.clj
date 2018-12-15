#!/usr/bin/env boot

(defn square [x] (* x x))

(defn fast-expt [b n]
  (defn- iter [a b n]
    (cond (= n 0) a
          (even? n) (recur a (square b) (/ n 2))
          :else (recur (* a b) b (- n 1))))
  (iter 1 b n))

