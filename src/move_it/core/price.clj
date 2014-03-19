(ns move-it.core.price)

(defn number-of-cars [offer]
  (let [total-area (+ (:residential-area offer)
                      (* 2 (:basement-area offer)))]
    (inc (int (/ total-area 50)))))

(defn price-per-car [offer]
  (let [dist (:distance offer)]
    (if (< dist 50)
      (+ 1000 (* dist 10))
      (if (< dist 100 )
        (+ 5000 (* dist 8))
        (+ 10000 (* dist 7))))))

(defn get-price [offer]
  (let [n (number-of-cars offer)
        p (price-per-car offer)
        base-price (* n p)
        piano-extra (if (:piano offer) 5000 0)]
    (+ base-price piano-extra)))
