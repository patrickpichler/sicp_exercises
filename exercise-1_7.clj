#!/usr/bin/env boot

(:import java.lang.Math)

(defn square [x]
  (* x x))

(defn good-enough? "method which tests if the result of the approximation is good
                   enough to be a sqrt" [guess number]
  (< (Math/abs (- (improve guess number) guess)) (* guess 0.001)))

(defn average "calculates the average of the given number" [x y]
  (/ (+ x y) 2))

(defn improve "returns a new improved guess for the square root of the given number" 
  [guess number]
  (average (/ number guess) guess))

(defn sqrt-iter "uses newton newtons method of successive approximation to find 
                the square root of a given number. 
                
                The given guess parameter is the starting point of the calculation" 
  [guess number]
  (if (good-enough? guess number) guess
    (let [improved-guess (improve guess number)] 
       (recur improved-guess number))))


(defn sqrt "calulates the square root of a given number" [number]
  (sqrt-iter 1.0 number))

(defn -main "main function" [& args]
  (println (sqrt (first args))))

(def numbers [1 2 0.001 0.000005 10000000000])

(run! println (map #(list %1 (sqrt %1)) numbers))
