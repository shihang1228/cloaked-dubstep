#!/bin/sh

mkdir $CATALINA_HOME/webapps/contact/
cp -r src/main/webapp/* $CATALINA_HOME/webapps/contact/
cp -r target/classes/ $CATALINA_HOME/webapps/contact/WEB-INF/
cp -r lib $CATALINA_HOME/webapps/contact/WEB-INF/
