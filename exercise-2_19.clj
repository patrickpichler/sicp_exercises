#!/usr/bin/env boot

(defn make-pair [a b]
  (vector a b))

(defn car [pair] (first pair))
(defn cdr [pair] (last pair))

(defn make-list [& items]
  (defn list-maker [[f & r]]
    (cond 
      (nil? f) nil
      (nil? r) (make-pair f nil)
      :else (make-pair f (list-maker r))))
  
  (list-maker items))

(defn no-more? [values] (nil? values))
(defn except-first-denomination [[h t]] t)
(defn first-denomination [[h t]] h)

(defn cc [amount coin-values]
  (cond (= amount 0) 1
        (or (< amount 0) (no-more? coin-values)) 0
        :else (+ (cc amount
                     (except-first-denomination coin-values))
                 (cc (- amount
                        (first-denomination coin-values))
                     coin-values))))

(cc 100 (make-list 5 1 10 25 50))

; the order of the coins doesn't matter 'cause for each value all combinations
; 'til the amount <= 0 are tried
