#!/bin/bash

cd /d/Articles/Frontend/Web/
mvn clean install
cd /d/Dev/jboss-as-7.1.1.Final/standalone/deployments/
rm web.war.deployed
cd /d/Articles/Frontend/Web/target/
pwd
cp `ls | grep .war` /d/Dev/jboss-as-7.1.1.Final/standalone/deployments/
sleep 5
cd /d/Dev/jboss-as-7.1.1.Final/standalone/deployments/
rm web.war.unDeployed
echo "Deployed"