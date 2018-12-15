#!/usr/bin/env boot

(defn slow-mult [a b]
  (if (or (= 0 a) (= b 0)) 0
    (+ a (slow-mult a (dec b)))))

(defn do-double [x] (+ x x))

(defn half [x] 
  (if (even? x) (/ x 2)
    (throw (Throwable. "Given number is not even!"))))

(defn ok-mult [a b]
  (cond (or (= a 0) (= b 0)) 0
        (= a 1) b
        (= b 1) a
        (even? a) (do-double (ok-mult (half a) b))
        :else (+ b (ok-mult (dec a) b))))
