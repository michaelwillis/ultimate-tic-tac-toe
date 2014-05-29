(ns ultimate-tic-tac-toe.core)

(def empty-sub-grid (->> nil repeat (take 9) (vec)))

(def empty-super-grid (->> empty-sub-grid repeat (take 9) vec))

(def wins [[0 1 2] [3 4 5] [6 7 8] [0 3 6] [1 4 7] [2 5 8] [0 4 8] [2 4 6]])

(defn winner
  ([sub-grid line]
     (let [tokens (map sub-grid line)]
       (when (-> tokens distinct count (= 1)) (first tokens))))
  ([sub-grid]
     (->> wins (map (partial winner sub-grid)) (filter identity) first)))
