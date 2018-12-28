#!/usr/bin/env boot

(defn product [term a nextF b]
  (defn- iter [a result]
    (if (> a b) result
      (recur (nextF a) (* (term a) result))))
  
  (iter a 1))

(defn factorial [n] 
  (product identity 1 inc n))


(defn pi [n] 
  (defn- upper-term [x]
    (if (even? x) (+ 2 x)
               (+ 2 (inc x))))
  
  (defn- lower-term [x]
    (if (odd? x) (+ 2 x)
              (+ 2 (inc x))))

  (defn- term [x]
    (/ (upper-term x)
       (lower-term x)))
  
  (* 4 (product term 0 inc n)))

(defn -main [& args]
  (println "hello world"))
