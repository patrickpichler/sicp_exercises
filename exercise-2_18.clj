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

(defn reverse-list [l]
  (defn iter [new-list [first-old & [rest-old]]]
    (cond 
     (nil? first-old) new-list
     (nil? rest-old) (make-pair first-old new-list)
     :else (recur (make-pair first-old new-list) rest-old)))
  
  (iter nil l))

(println (make-list 1 2 3 4))
(println (reverse-list (make-list 1 2 3 4)))

