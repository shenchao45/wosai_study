FROM jetty:9.3.21-jre8

ADD war/target/wosai-war.war $JETTY_BASE/webapps/ROOT.war