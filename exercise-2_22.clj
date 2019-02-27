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

(defn for-each [m [f & [r]]]
  (if (not (nil? f))
    (do (m f)
        (recur m r))))


(for-each println (make-list 1 2 3 4 5))
