(ns my-shelves.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[my-shelves started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[my-shelves has shutdown successfully]=-"))
   :middleware identity})
