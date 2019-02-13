#!/usr/bin/env boot

(defn make-interval [a b] (list a b))
(defn lower-bound [i] (min (first i) (last i)))
(defn upper-bound [i] (max (first i) (last i)))

(defn mul-interval [a b]
  (let [p1 (* (lower-bound a) (lower-bound b))
        p2 (* (lower-bound a) (upper-bound b))
        p3 (* (upper-bound a) (lower-bound b))
        p4 (* (upper-bound a) (upper-bound b))]
    (make-interval (min p1 p2 p3 p4)
                   (max p1 p2 p3 p4))))

(defn div-interval [a b]
  (if (<= 0 (* (lower-bound b) (upper-bound b)))
    (throw (Exception. "Divsor spans zero!"))
    (mul-interval a 
                 (make-interval (/ 1 (upper-bound b))
                                (/ 1 (lower-bound b))))))

(defn print-interval [a]
  (println (str (lower-bound a) " - " (upper-bound a))))

(def interval1 (make-interval 2 4))
(def interval2 (make-interval 0 2))

(print-interval (div-interval interval1 interval2))
