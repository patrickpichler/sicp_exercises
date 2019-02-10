#!/usr/bin/env boot

(defn make-interval [a b] (list a b))
(defn lower-bound [i] (min (first i) (last i)))
(defn upper-bound [i] (max (first i) (last i)))

(defn sub-interval [a b] 
  (make-interval (- (lower-bound a) (upper-bound b))
                 (- (upper-bound a) (lower-bound b))))

(defn to-string-interval [a]
  (str "Lower: " (lower-bound a) ", Upper: " (upper-bound a)))

(def test-interval (make-interval 10 100))
(def test-interval2 (make-interval 20 90))

(println (to-string-interval (sub-interval test-interval test-interval2)))

