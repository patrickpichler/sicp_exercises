#!/usr/bin/env boot

(defn accumulate [combiner null-value term a nextF b]
  (defn- iter [a result]
    (if (> a b) result
      (recur (nextF a) (combiner (term a) result))))
  
  (iter a null-value))

(defn product [term a nextF b]
  (accumulate * 1 term a nextF b))

(defn sum [term a nextF b]
  (accumulate + 0 term a nextF b))

(defn -main [& args]
  (println "hello world"))
