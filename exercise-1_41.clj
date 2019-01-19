#!/usr/bin/env boot

(defn do-double [f] 
  (fn [x] (f (f x))))

(defn -main [& args]
  (println ((do-double inc) 5))
  (println (((do-double do-double) inc) 5))
  (println (((do-double (do-double do-double)) inc) 5)))
