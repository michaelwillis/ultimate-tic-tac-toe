(ns ultimate-tic-tac-toe.core)

(def empty-sub-grid (->> {:value nil} repeat (take 9) (vec)))

(def empty-super-grid (->> {:value nil :subgrid empty-sub-grid} repeat (take 9) vec))

(def wins [[0 1 2] [3 4 5] [6 7 8] [0 3 6] [1 4 7] [2 5 8] [0 4 8] [2 4 6]])

(defn load-subgrid [input]
  (cond
    (string? input)
      (load-subgrid (map keyword (replace {"." nil " " nil} (map str input))))
    (coll? input)
      (vec (for [item input] {:value item}))))

(defn winner
  ([grid line]
     (let [tokens (map :value (map grid line))]
       (when (-> tokens distinct count (= 1)) (first tokens))))
  ([grid]
     (->> wins (map (partial winner grid)) (remove nil?) first)))
