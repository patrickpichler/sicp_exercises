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

(defn pair? [p]
  (and (vector? p) (= (count p) 2)))

(defn reverse-list [l]
  (defn iter [result [f & [r]]]
    (cond (nil? f) nil
          (nil? r) (make-pair f result)
          :else    (recur (make-pair f result) r))) 
    (iter nil l))

(defn deep-reverse-list [l]
  (defn iter [result [f & [r]]]
    (let [reverse-f (if (pair? f) (deep-reverse-list f) f)]
      (cond (nil? f) nil
           (nil? r) (make-pair reverse-f result)
           :else    (recur (make-pair reverse-f result) r)))) 
    (iter nil l))

(println (reverse-list (make-list 1 2 3 4)))
(println (deep-reverse-list (make-list 1 (make-list 6 7) 3 4)))

