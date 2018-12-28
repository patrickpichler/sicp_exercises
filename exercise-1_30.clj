#!/usr/bin/env boot

(defn sum [term a nextF b]
  (defn- iter [a result]
    (if (> a b) result
      (recur (nextF a) (+ (term a) result))))
  
  (iter a 0))

(defn -main [& args]
  (println "hello world"))
