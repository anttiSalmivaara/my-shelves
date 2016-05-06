(ns my-shelves.routes.home
  (:require [my-shelves.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [my-shelves.db.core :as db]
            [bouncer.core :as b]
            [bouncer.validators :as v]
            [ring.util.response :refer [redirect]]))

(defn validate-book [params]
  (first
    (b/validate
      params
      :title v/required)))

(defn add-book! [{:keys [params]}]
  (if-let [errors (validate-book params)]
    (-> (response/found "/")
        (assoc :flash (assoc params :errors errors)))
    (do
      (db/add-book!)
      (response/found "/add"))))

(defn delete-book! [{:keys [params]}]
  (do
    (db/delete-book!)
    (response/found "/my-books")))

(defn get-book! [{:keys [params]}]
  (do
    (db/get-book!)
    (response/found "")))

(defn update-book! [{:keys [params]}]
  (do
    (db/update-book!)
    (response/found "/my-books")))

(defn home-page [{:keys [flash]}]
  (layout/render
    "home.html"
    (select-keys flash [:errors])))

(defn my-books-page [{:keys [params]}]
  (layout/render
    "view.html"
    {:books (db/get-all-books!)}))

(defroutes home-routes
  (GET "/" request (home-page))
  (GET "/add" [] (add-page))
  (POST "/add" request (add-book!))
  (GET "/my-books" request (my-books-page))
  (GET "/my-books/:id" request (get-book!))
  (POST "/my-books/:id" request (update-book!))
  (POST "/delete/:id" request (delete-book!)))

