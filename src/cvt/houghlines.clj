(ns cvt.houghlines
  (:use [clojure.java.io :as io])
  (:import
   (org.openimaj.image ImageUtilities)
   (org.openimaj.image.processing.edges CannyEdgeDetector)
   (org.openimaj.image.analysis.algorithm HoughLines)))

(defn -main
  ""
  [image-path]
  (let [ced (CannyEdgeDetector.)
        hl  (HoughLines.)
        i (ImageUtilities/readF (io/file image-path))]
    (.processImage ced i)
    (let [ii (.inverse i)]
      (.analyseImage hl ii)
      (doall ((fn [l]
                (println (str l)))
              (iterator-seq (.iterator hl))))
      )))
