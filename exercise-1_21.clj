#!/usr/bin/env boot

(defn- square [x] (* x x))

(defn- divide? [x n] 
  (= (mod n x) 0))

(defn- find-smallest-divsor [n number-to-test]
  (cond (> (square number-to-test) n) n
        (divide? number-to-test n) number-to-test
        :else (recur n (inc number-to-test))))

(defn smallest-divisor [n]
  (find-smallest-divsor n 2))

(defn -main  [& args]
  (println "Hello world"))
