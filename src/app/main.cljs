(ns app.main
  (:require [reagent.core :as r]
            ["react-modal" :as Modal]))

(.setAppElement Modal "#app")

(defn app
  []
  (let [modal-state (r/atom false)]
    (fn []
      [:div {:style {:margin "auto"
                     :margin-top "100px"
                     :width "600px"}}
       [:h1 "hi"]
       [:button {:on-click #(swap! modal-state not)}
        "Button"]
       [:> Modal {:isOpen @modal-state
                  :onRequestClose #(reset! modal-state false)
                  :contentLabel "Example Modal"
                  :shouldCloseOnOverlayClick true
                  :style {:content {:top         "50%"
                                    :left        "50%"
                                    :right       "auto"
                                    :bottom      "auto"
                                    :marginRight "-50%"
                                    :transform   "translate(-50%, -50%)"}}}
        [:div
         "This is a modal"
         [:ul
          [:li "With content"]
          [:li "And lists"]]]]
       [:div {:style {:margin-top "25px"
                      :display "flex"
                      :justify-content "center"
                      :font-size "75%"
                      :font-weight "100"
                      :font-variant "small-caps"}}
        "Presentation about this site here: "
        [:a {:href "https://suspicious-archimedes-390f0a.netlify.com/"}
         "Reveal.js site on Netlify"]]])))

(defn ^:dev/after-load start []
  (r/render [app]
            (.getElementById js/document "app")))

(defn ^:export main
  []
  (start))
