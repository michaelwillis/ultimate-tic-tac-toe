(ns ultimate-tic-tac-toe.core-test
  (:require [clojure.test :refer :all]
            [ultimate-tic-tac-toe.core :refer :all]))

(deftest subgrid-winner
  (testing "Grids without three in a row have no winner"
    (is (nil? (winner empty-sub-grid)))

    (is (nil? (winner [:x  :o  :x
                       nil nil  :o
                       :o  nil :x]))))

  (testing "Three in a row should win"
    (is (= :x (winner [:x  :o  :x
                       nil :x  :o
                       :o  nil :x])))

    (is (= :x (winner [:x  :x  :x
                       nil nil :o
                       :o  nil :x])))

    (is (= :o (winner [:x nil :x
                       :o  :o :o
                       :x :o :x])))))
