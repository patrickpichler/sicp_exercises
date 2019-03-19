#!/usr/bin/env boot

(defn make-vect [x y]
  (vector x y))

(defn xcor-vect [v] (first v))
(defn ycor-vect [v] (last v))

(defn binary-vector-operation [op v1 v2]
  (let [x (op (xcor-vect v1) (xcor-vect v2))
        y (op (ycor-vect v1) (ycor-vect v2))]
    (make-vect x y)))

(defn add-vect [v1 v2] 
  (binary-vector-operation + v1 v2))

(defn sub-vect [v1 v2] 
  (binary-vector-operation - v1 v2))

(defn scale-vect [s v]
  (let [x (* s (xcor-vect v))
        y (* s (ycor-vect v))]
    (make-vect x y)))

(defn to-string-vect [v]
  (str "[" (xcor-vect v) ", " (ycor-vect v) "]"))

(def v1 (make-vect 1 1))
(def v2 (make-vect 2 2))

(println (to-string-vect (add-vect v1 v2)))
(println (to-string-vect (sub-vect v2 v1)))
(println (to-string-vect (scale-vect 2 v1)))
