(ns user
  (:require [mount.core :as mount]
            my-shelves.core))

(defn start []
  (mount/start-without #'my-shelves.core/repl-server))

(defn stop []
  (mount/stop-except #'my-shelves.core/repl-server))

(defn restart []
  (stop)
  (start))


