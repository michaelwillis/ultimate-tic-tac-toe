(ns ultimate-tic-tac-toe.core-test
  (:require [clojure.test :refer :all]
            [ultimate-tic-tac-toe.core :refer :all]))

(def test-grid [{:value nil :subgrid (load-subgrid ".........")} {:value :x  :subgrid (load-subgrid ".x..x..x.")} {:value nil :subgrid (load-subgrid ".........")}
                {:value :o  :subgrid (load-subgrid "...ooo...")} {:value :x  :subgrid (load-subgrid "......xxx")} {:value nil :subgrid (load-subgrid ".........")}
                {:value :o  :subgrid (load-subgrid "..o.o.o..")} {:value :x  :subgrid (load-subgrid "x...x...x")} {:value nil :subgrid (load-subgrid ".........")}])

(deftest subgrid-winner
  (testing "Grids without three in a row have no winner"
    (is (nil? (winner empty-sub-grid)))

    (is (nil? (winner (load-subgrid
                      [:x  :o  :x
                       nil nil :o
                       :o  nil :x])))))

  (testing "Three in a row should win"
    (is (= :x (winner (load-subgrid
                      [:x  :o  :x
                       nil :x  :o
                       :o  nil :x]))))

    (is (= :x (winner (load-subgrid
                      [:x  :x  :x
                       nil nil :o
                       :o  nil :x]))))

    (is (= :o (winner (load-subgrid
                      [:x nil :x
                       :o  :o :o
                       :x :o :x])))))

  (testing "Testing empty super grid has no winner")
    (is (nil? (winner empty-super-grid)))

  (testing "Testing sub and super grids using same winner function"
    (is (= :x (winner test-grid))))
    (is (= :o (winner (:subgrid (nth test-grid 3))))))
