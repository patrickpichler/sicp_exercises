#!/usr/bin/env boot

(defn cube [x] (* x x x))
(defn square [x] (* x x))

(defn cubic [a b c]
  (fn [x] (+ (cube x) 
            (* a (square x)) 
            (* b x) 
            c)))

(defn -main [& args]
  (println "hello world"))
