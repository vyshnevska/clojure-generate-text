(ns tom-swift.core
  (:gen-class)
  (:require [clojure.string :as str])
 )

(def words-set {"I wish" ["I", "I"]
   "wish I" ["may" "might"]
   "may I"  ["wish"]
   "I may"  ["I"]}
)

(defn concatenate [start]
  (str start " " (rand-nth (get words-set start)))
)

(defn get-next-key [start-key]
  (str/join " " (rest (str/split (concatenate start-key) #" ")))
)

(defn get-next-value [start-key]
  (rand-nth (get words-set start-key))
 )

(defn generate-output [start-key-param result-output-param]
  (loop [start-key start-key-param result-output result-output-param]
    (if (nil? (get words-set start-key))
      result-output
      (recur        
        (get-next-key start-key)
        (str result-output " " (get-next-value start-key))
       ))
   )
)


(defn -main []
 (dotimes [n 6] (generate-output "I wish" "I wish"))
)
  
