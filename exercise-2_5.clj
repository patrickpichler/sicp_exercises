#!/usr/bin/env boot

(defn square [x] (* x x))

(defn exp [base n]
  (defn- iter [result b x]
    (cond (= x 0) result
          (even? x) (recur result (square b) (/ x 2))
          :else (recur (* result b) b (dec x))))
  
  (iter 1 base n))

(defn pair [a b] (* (exp 2 a) (exp 3 b)))

(defn count-0-remainder-division [n divisor]
  (defn- iter [try-exp]
    (if (= (mod n (exp divisor try-exp)) 0)
      (recur (inc try-exp))
      (dec try-exp)))
  
  (iter 1))

(defn car [pair] (count-0-remainder-division pair 2))
(defn cdr [pair] (count-0-remainder-division pair 3))

(->> (list (pair 1 2) (pair 2 2) (pair 3 2))
     (map #(list %1 (car %1) (cdr %1)))
     (run! println))


