#!/usr/bin/env boot

(defn make-interval [a b] (list a b))
(defn lower-bound [i] (min (first i) (last i)))
(defn upper-bound [i] (max (first i) (last i)))

(defn mul-interval [a b]
  (let [p1 (* (lower-bound a) (lower-bound b))
        p2 (* (lower-bound a) (upper-bound b))
        p3 (* (upper-bound a) (lower-bound b))
        p4 (* (upper-bound a) (upper-bound b))]
    (make-interval (min p1 p2 p3 p4)
                   (max p1 p2 p3 p4))))


(defn to-string-interval [a]
  (str (lower-bound a) " - " (upper-bound a)))

(defn make-center-width [c w]
  (make-interval (- c w) (+ c w)))

(defn center [i]
  (/ (+ (lower-bound i) (upper-bound i)) 2))

(defn width [i]
  (/ (- (upper-bound i) (lower-bound i)) 2))

(defn make-center-percent [center tolerance]
  (let [width (* center tolerance)
        ]
    (make-center-width center width)))

(defn percent [i]
  (/ (* (/ 100 (center i)) (width i)) 100))

(def test-interval (make-center-percent 10 0.5))
(def test-interval1(make-center-percent 10 1.5))

(println (to-string-interval test-interval))
(println (percent test-interval))
(println (to-string-interval test-interval1))
(println (percent test-interval1))
