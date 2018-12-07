
(defn square "squares-given-numer" [a]
  (* a a))

(defn sum-squares "sum the squares of the given numbers" [a b]
  (+ (square a) (square b)))

(defn sum-of-squares-of-larger-numbers "sums the squares of larger numbers " [a b c]
  (cond (and (>= a c) (>= b c)) (sum-squares a b)
        (and (>= b a) (>= c a)) (sum-squares b c)
        (and (>= a b) (>= c b)) (sum-squares a c)))

(defn -main [&args]
  (print args))
