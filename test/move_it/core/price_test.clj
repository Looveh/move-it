(ns move-it.core.price-test
  (:require [move-it.core.price :refer :all]
            [expectations :refer :all]))

(expect true false)

(expect 1100 (price-per-car { :distance 10 }))

(expect 1490 (price-per-car { :distance 49 }))

(expect 5400 (price-per-car { :distance 50 }))

(expect 5408 (price-per-car { :distance 51 }))

(expect 5792 (price-per-car { :distance 99 }))

(expect 10700 (price-per-car { :distance 100 }))

(expect 10721 (price-per-car { :distance 103 }))

(expect 1 (number-of-cars { :residential-area 49
                            :basement-area 0 }))

(expect 2 (number-of-cars { :residential-area 10
                            :basement-area 25 }))

(expect 2 (number-of-cars { :residential-area 50
                            :basement-area 0 }))

(expect 3 (number-of-cars { :residential-area 100
                            :basement-area 0 }))

(expect 4 (number-of-cars { :residential-area 150
                            :basement-area 0 }))

(expect 1100 (get-price { :distance 10
                          :residential-area 49
                          :basement-area 0
                          :piano false
                          :pack-help false }))

(expect 2200 (get-price { :distance 10
                          :residential-area 10
                          :basement-area 25
                          :piano false
                          :pack-help false }))

(expect 2200 (get-price { :distance 10
                          :residential-area 50
                          :basement-area 0
                          :piano false
                          :pack-help false }))

(expect 3300 (get-price { :distance 10
                          :residential-area 100
                          :basement-area 0
                          :piano false
                          :pack-help false }))

(expect 4400 (get-price { :distance 10
                          :residential-area 150
                          :basement-area 0
                          :piano false
                          :pack-help false }))

(expect 9400 (get-price { :distance 10
                          :residential-area 150
                          :basement-area 0
                          :piano true
                          :pack-help false }))

(expect 4400 (get-price { :distance 10
                          :residential-area 150
                          :basement-area 0
                          :piano false
                          :pack-help true }))

(expect 9400 (get-price { :distance 10
                           :residential-area 150
                           :basement-area 0
                           :piano true
                           :pack-help true }))

(expect 16584 (get-price { :distance 99
                           :residential-area 10
                           :basement-area 25
                           :piano true
                           :pack-help true }))
