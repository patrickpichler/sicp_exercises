#!/usr/bin/env boot

(defn zero [] (fn [f] (fn [x] x)))

(defn one [] (fn [f] (fn [x] (f x))))
(defn two [] (fn [f] (fn [x] (f (f x)))))

(defn add1 [n]
  (fn [f] (fn [x] (f ((n f) x)))))

(defn to-church [n] 
  (defn- iter [x result]
    (if (= x 0) result
      (recur (dec x) (add1 result))))
  
  (iter n (zero)))

(defn to-number [c]
  ((c inc) 0))

(defn mult [a b]
  (fn [f] (fn [x] ((b (a f)) x))))

(defn add [a b]
  (fn [f] (fn [x] ((b f) ((a f) x)))))

(println (to-number (add1 (two))))
(println (to-number (to-church 6)))
(println (to-number (add (to-church 3) (to-church 5))))
(println (to-number (add (two) (one))))
