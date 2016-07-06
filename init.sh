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
oc login https://10.1.2.2:8443 -u admin -p admin

echo
echo "Use new projects"
echo
oc new-project fisdemo

echo
echo "Import weightwatcher template:"
echo
oc create -f support/weightwatcher-template.json

echo
echo "Create the decision server application"
echo
oc new-app decisionserver62-weightwatcher-s2i --param=KIE_SERVER_PASSWORD=kieserver1!


echo
echo "Add amq62 template:"
echo
oc create -f support/amq62-basic.json

echo
echo "Create a new project and deploy the Message Server:"
echo
oc new-app amq62-basic --param=MQ_PROTOCOL=openwire


echo
echo "Add fuse template:"
echo
oc create -f support/fis-image-streams.json

echo
echo "Install Fuse RESTful endpoints"
echo
oc new-app -f support/fusetemplate.json



echo
echo "=============================================================================================="
echo "=                                                                                            ="
echo "=  Access OpenShift console: https://10.1.2.2:8443/console                                   ="
echo "=  With ID/PWD admin/admin                                                                   ="
echo "=  http://healthcareweb-demo.rhel-cdk.10.1.2.2.xip.io/health.html                            ="
echo "=                                                                                            ="
echo "=  Register the participants and set their goal. .                                           ="
echo "=                                                                                            ="
echo "=  http://YOUREXPOSEDROUTE/weightwatcher/addParticipant/2/ipavlov@behaviorist.org/75/84/70/78="
echo "=                                                                                            ="
echo "=  And then send the observation                                                             ="
echo "=                                                                                            ="
echo "=  http://YOUREXPOSEDROUTE/weightwatcher/updateweight/2/2015-04-20%2007:15:00%20EST/79       ="
echo "=  http://YOUREXPOSEDROUTE/weightwatcher/updateweight/2/2015-04-25%2007:15:00%20EST/77       ="
echo "=  http://YOUREXPOSEDROUTEweightwatcher/updateweight/2/2015-04-28%2007:15:00%20EST/76        ="
echo "=                                                                                            ="
echo "=============================================================================================="
echo