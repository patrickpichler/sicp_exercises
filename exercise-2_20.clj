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

(defn filter-list [p l]
  (defn iter [result [f & [r]]]
    (cond
      (nil? f) result
      (and (nil? r) (not (p f))) result
      (and (nil? r) (p f)) (make-pair f result)
      (p f) (recur (make-pair f result) r)
      :else (recur result r)))
  (reverse-list (iter nil l)))

(defn same-parity [[f :as all]]
  (filter-list (if (odd? f) odd? even?) all))

(same-parity (make-list 2 3 4 5 6))
(same-parity (make-list 1 2 3 4 5 6))

