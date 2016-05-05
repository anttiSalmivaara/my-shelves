(ns my-shelves.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [my-shelves.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[my-shelves started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[my-shelves has shutdown successfully]=-"))
   :middleware wrap-dev})
