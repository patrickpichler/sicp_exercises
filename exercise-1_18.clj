#!/usr/bin/env boot

(defn do-double [x] (+ x x))

(defn half [x] 
  (if (even? x) (/ x 2)
    (throw (Throwable. "Given number is not even!"))))

(defn fast-mult [a b]
  (defn- iter [a b n] 
    (cond (or (= a 0) (= b 0)) n
          (even? a) (recur (half a) (do-double b) n)
          :else (recur (dec a) b (+ b n))))
  (iter a b 0))
