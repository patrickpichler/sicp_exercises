#!/usr/bin/env boot

(defn make-point [x y] (list x y))

(defn x-point [point] (first point))
(defn y-point [point] (last point))

(defn to-string-point [p]
  (str "(" (x-point p) "," (y-point p) ")"))

(defn print-point [p]
  (println (to-string-point p)))

(defn make-segment [start end] (list start end))

(defn start-segment [segment] (first segment))
(defn end-segment [segment] (last segment))

(defn print-segment [segment] 
  (println "[" (to-string-point (start-segment segment)) ","
           (to-string-point (end-segment segment))"]"))

(defn avarage [x y] (/ (+ x y) 2))

(defn midpoint-segment [segment] 
  (let [start (start-segment segment)
        end (end-segment segment)]
    
    (make-point (avarage (x-point start) (x-point end))
                (avarage (y-point start) (y-point end)))))

(make-segment (make-point 1 1) (make-point 2 2))
(def test-segment (make-segment (make-point 1 1) (make-point 2 2)))

(print-segment test-segment)
(print-point (midpoint-segment test-segment))


(defn -main [& args]
  (println "hello world"))
