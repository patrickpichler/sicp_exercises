#!/usr/bin/env boot

(defn make-point [x y] (list x y))

(defn x-point [point] (first point))
(defn y-point [point] (last point))

(defn to-string-point [p]
  (str "(" (x-point p) "," (y-point p) ")"))

(defn print-point [p]
  (println (to-string-point p)))

(defn make-rect [upper-left height width] (list upper-left height width))

(defn height-rect [rect] (nth rect 1))
(defn width-rect [rect] (last rect))

(defn perimeter-rect [rect] 
  (+ (* 2 (height-rect rect)) (* 2 (width-rect rect))))

(defn area-rect [rect]
  (* (height-rect rect) (width-rect rect)))


(def test-rect (make-rect (make-point 1 1) 2 5))

(perimeter-rect test-rect)
(perimeter-rect test-rect)
