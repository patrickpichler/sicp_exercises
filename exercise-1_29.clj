#!/usr/bin/env boot

(defn simpsons-rule [f a b n]
  (let [h (/ (- b a) n)]

    (defn yk [k] (f (+ a (* h k))))

    (defn get-multiplier [k]
      (cond (= k 0) 1
            (= k n) 1
            (odd? k) 4
            :else 2))

    (defn simpsons-term [k]
      (* (get-multiplier k)
         (yk k)))

    (defn get-simpsons-sum []
      (->> (range (inc n))
          (map simpsons-term)
          (reduce +)))
    
    (* (/ h 3) (get-simpsons-sum))))

(defn cube [x] (* x x x))

(defn -main [& args]
  (println (simpsons-rule cube 0 1 1000)))
