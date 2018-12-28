#!/usr/bin/env boot

(defn simpsons-rule [f a b n]
  (let [h (/ (- b a) n)]

    (defn simpsons-rule-iter [k]
     (cond (not= k n) (+ (f (+ a (* k h))) 
                          (simpsons-rule-iter (inc k)))
            :else (f (+ a (* k h)))))
    
    (* (/ h 3) (simpsons-rule-iter 0))))

(defn cube [x] (* x x x))

(defn -main [& args]
  (println (simpsons-rule cube 0 1 1000)))
