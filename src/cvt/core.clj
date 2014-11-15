(ns cvt.core)

(defn image-file-seq
  "file-seq + filter that gives only a sequence of image files."
  [path]
  (filter (fn [it] (and (.isFile it) (re-find #".((?i)jpg|png)$" (.getPath it)))) (file-seq (io/file path))))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
