(defproject move-it "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [com.novemberain/monger "1.7.0"]
                 [ring/ring-jetty-adapter "1.2.1"]
                 [compojure "1.1.6"]
                 [formative "0.8.8"]
                 [expectations "1.4.52"]
                 [hiccup "1.0.4"]]
  :plugins [[lein-autoexpect "1.0"]]
  :main move-it.web.server)
