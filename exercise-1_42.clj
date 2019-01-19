#!/usr/bin/env boot

(defn compose [f g]
  (fn [x] (f (g x))))

(defn square [x] (* x x))

(defn -main [& args]
  (println ((compose square inc) 6)))
