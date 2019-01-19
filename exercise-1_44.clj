#!/usr/bin/env boot

(defn repeated [f n]
  (defn- repeated-iter [g n]
    (if(= n 1) g
      (recur (fn [x] (f (g x))) (dec n))))
  (repeated-iter f n))

(defn square [x] (* x x))

(def dx 0.001)

(defn smooth [f] 
  (fn [x] (/ (+ (f (- x dx)) (f x) (f (+ x dx))) 3)))

(defn n-smooth [f n]
  ((repeated smooth n) f))

(defn -main [& args]
  (println ((smooth inc) 1))
  (println ((smooth (smooth inc)) 1))
  (println ((n-smooth inc 3) 1))
  )
