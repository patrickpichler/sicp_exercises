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

(defn prime? [n]
  (= (smallest-divisor n) n))

(defn report-prime [elapsed-time]
  (println (str " *** " elapsed-time)))

(defn start-prime-test [n start-time]
  (if (prime? n)
    (report-prime (- (System/nanoTime) start-time))))

(defn timed-prime-test [n]
  (println)
  (println n)
  (start-prime-test n (System/nanoTime)))

(defn -main [& args]
  (println "hello world"))
