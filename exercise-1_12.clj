#!/usr/bin/env boot

(defn pascal-triangle [row column]
  (if (or (= row 0) (= column 0) (= row column)) 1
    (+ (pascal-triangle (- row 1) (- column 1))
       (pascal-triangle (- row 1) column))))

(defn -main [& args]
  (let [[x y] args]
    (println (pascal-triangle (Integer/parseInt x) (Integer/parseInt y)))))
