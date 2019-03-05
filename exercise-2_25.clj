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

(def a (make-list 1 3 (make-list 5 7) 9))
(def b (make-list (make-list 7)))
(def c (make-list 1 (make-list 2 (make-list 3 (make-list 4 (make-list 5 (make-list 6 7)))))))

(println (->> a cdr cdr car cdr car))
(println (->> b car car))
(println (->> c cdr car cdr car cdr car cdr car cdr car cdr car ))

