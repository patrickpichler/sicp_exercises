#!/usr/bin/env boot

(defn repeated [f n]
  (defn- repeated-iter [g n]
    (if(= n 1) g
      (recur (fn [x] (f (g x))) (dec n))))
  (repeated-iter f n))

(defn square [x] (* x x))

(defn -main [& args]
  (println ((repeated inc 2) 5))
  (println ((repeated inc 3) 5))
  (println ((repeated square 2) 5)) 
  )
