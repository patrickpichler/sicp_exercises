#!/usr/bin/env boot

(defn make-interval [a b] (list a b))
(defn lower-bound [i] (min (first i) (last i)))
(defn upper-bound [i] (max (first i) (last i)))

(def test-interval (make-interval 10 100))

(println (lower-bound test-interval))
(println (upper-bound test-interval))
