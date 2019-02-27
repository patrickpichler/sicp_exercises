#!/usr/bin/env boot

(defn make-pair [a b]
  (vector a b))

(defn car [pair] (first pair))
(defn cdr [pair] (last pair))

(defn make-list [& items]
  (defn list-maker [[f & r]]
    (cond 
      (nil? f) nil
      (nil? r) (make-pair f nil)
      :else (make-pair f (list-maker r))))

  (list-maker items))

(defn square [x] (* x x))

(defn square-list-1 [[f & [r]]]
  (if (nil? f) nil
    (make-pair (square f) (square-list-1 r))))

(defn map-list [m [f & [r]]]
  (if (nil? f) nil
    (make-pair (m f) (map-list m r))))

(defn square-list-2 [l] (map-list square l))

(def test-list (make-list 1 2 3 4 5))

(println (square-list-1 test-list))
(println (square-list-2 test-list))
