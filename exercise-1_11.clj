#!/usr/bin/env boot

(defn function-recursive [n]
  (if (< n 3) n
    (+ (function-recursive (- n 1))
       (* 2 (function-recursive (- n 2)))
       (* 3 (function-recursive (- n 3))))))

(defn function-iter [n-1 n-2 n-3 c]
  (let [n (+ n-1 (* 2 n-2) (* 3 n-3))]
    (if (= c 0) n
      (recur n n-1 n-2 (- c 1)))))

(defn function-iterative [n] 
  (if (< n 3) n
    (function-iter 2 1 0 (- n 3))))

(defn -main [& args]
  (->> args 
       (map #(Long/parseLong %1))
       (map #(vector %1 (function-recursive %1) (function-iterative %1)))
       (run! println)))
