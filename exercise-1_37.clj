#!/usr/bin/env boot

(defn cont-frac [n d k]
  (defn- term-i [i dn]
    (/ (n i) (+ (d i) dn)))

  (defn- iter [c result]
    (if (< c 0) result
      (recur (dec c) (term-i c result))))

  (iter k 0))

(defn -main [& args]
  (println (double (cont-frac (fn [x] 1)
                      (fn [x] 1)
                      100))))
