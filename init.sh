#!/bin/sh 
DEMO="FIS Weightloss DEMO"
AUTHORS="Christina Lin, Andrew Block"
PROJECT="git@github.com:eschabell/cdk-install-demo.git"
PRODUCT="JBoss Fuse,JBoss BRMS, Container Development Kit, OpenShift"
CDK_HOME=./target
SRC_DIR=./installs
SUPPORT_DIR=./support
PRJ_DIR=./projects
CDK_PLUGINS_DIR=$CDK_HOME/cdk/plugins
CDK=cdk-2.1.0.zip
OSX_BOX=rhel-cdk-kubernetes-7.2-25.x86_64.vagrant-virtualbox.box
LINUX_BOX=rhel-cdk-kubernetes-7.2-25.x86_64.vagrant-libvirt.box
OSX_CLIENT=oc-3.1.1.6-macosx.tar.gz
LINUX_CLIENT=oc-3.1.1.6-linux.tar.gz
OSE_CLIENT_PATH=ose-clients-3.1.1.6
VAGRANTFILE=VagrantFile-rhel-ose
CDK_BOX_VERSION=cdkv2
VERSION=2.1.0

# wipe screen.
clear 

echo
echo "###########################################################################"
echo "##                                                                       ##"   
echo "##  Setting up the ${DEMO}                                 ##"
echo "##                                                                       ##"   
echo "##                                                                       ##"   
echo "##   ##### #   # ##### #####                                             ##"
echo "##   #     #   # #     #                                                 ##"
echo "##   ##### #   # # # # #####                                             ##"
echo "##   #     #   #     # #                                                 ##"
echo "##   #      ###  ##### #####                                             ##"
echo "##                                                                       ##"   
echo "##   ##### #   # ##### ##### ##### ##### ##### ##### ##### ##### #   #   ##"
echo "##     #   ##  #   #   #     #     #   # #   #   #     #   #   # ##  #   ##"
echo "##     #   # # #   #   ##### #  ## ##### #####   #     #   #   # # # #   ##"
echo "##     #   #  ##   #   #     #   # #  #  #   #   #     #   #   # #  ##   ##"
echo "##   ##### #   #   #   ##### ##### #   # #   #   #   ##### ##### #   #   ##"   
echo "##                                                                       ##"   
echo "##   ##### ##### ##### #   # ##### ##### #####                           ##"
echo "##   #     #     #   # #   #   #   #     #                               ##"
echo "##   # # # ##### ##### #   #   #   #     #####                           ##"
echo "##       # #     #  #   # #    #   #     #                               ##"
echo "##   ##### ##### #   #   #   ##### ##### #####                           ##"
echo "##                                                                       ##"
echo "##  brought to you by ${AUTHORS}     ##"
echo "##                                                                       ##"   
echo "##  ${PROJECT}            ##"
echo "##                                                                       ##"   
echo "###########################################################################"
echo



# Start adding application related projects

echo
echo "Login to OpenShfit"
echo
oc login -u admin -p admin

echo
echo "Import weightwatcher template:"
echo
oc create -f support/weightwatcher-template.json

echo
echo "Create the decision server application"
echo
oc new-app decisionserver62-weightwatcher-s2i --param=KIE_SERVER_PASSWORD=kieserver1!


echo
echo "Create a new project and deploy the Message Server:"
echo
oc new-app amq62-basic --param=MQ_PROTOCOL=openwire

echo
echo "Install Swagger"
echo
oc new-app -f fusetemplate.json --param=GIT_REPO=https://github.com/weimeilin79/weightwatcherapi.git



echo
echo "========================================================================="
echo "=                                                                       ="
echo "=  Now you can start build and deploy JBoss Fuse Camel services         ="
echo "=  Under project directory ./projects/healthcaredemo                    ="
echo "=                                                                       ="
echo "=     $ mvn -Pf8-local-deploy                                           ="
echo "=                                                                       ="
echo "=  After projects are depolyed, go back to the demo root directory      ="
echo "=  (where the init.sh is) we want to create two extra services          ="
echo "=                                                                       ="
echo "=     $ oc create -f support/clinichl7service.json                      ="
echo "=     $ oc create -f support/labrestservice.json                        ="
echo "=                                                                       ="
echo "=  Also expose a new route for the Lab Rest API Service                 ="
echo "=                                                                       ="
echo "=     $ oc create -f support/labrestapi.json                            ="
echo "=                                                                       ="
echo "=  Install GUI page and frontend for healthcare install                 ="
echo "=                                                                       ="
echo "=     $ oc new-app --image-stream=openshift/php:5.5 --name=healthcareweb --code=https://github.com/weimeilin79/healthcareweb.git "
echo "=                                                                       ="
echo "=  Install GUI page and frontend for healthcare install                 ="
echo "=                                                                       ="
echo "=     $ oc create -f support/healthwebroute.json                        ="
echo "=                                                                       ="
echo "=  Login to OpenShift console with USERNAME/PWD admin/admin             ="
echo "=                                                                       ="
echo "=     https://10.1.2.2:8443/console/                                    ="
echo "=                                                                       ="
echo "=                                                                       ="
echo "=  Finally, start playing with the demo by registering your info        ="
echo "=                                                                       ="
echo "=     http://healthcareweb-demo.rhel-cdk.10.1.2.2.xip.io/health.html    ="
echo "=                                                                       ="
echo "=  This completes the $DEMO setup.                           ="
echo "=                                                                       ="
echo "========================================================================="
echo                                                                    