# CordovaPlugin
Cordova Plugin for HangitSDK


Details about using the cordova plugin, as well as the plugin itself can be found in the Hangit_Plugin directory
A well-annotated, simple project demonstrating the usage of the plugin can be found in the hangitTestProject directory


Assuming you have cordova installed locally and are in a directory which contains the Hangit_Plugin, a minimal cordova project with the hangit plugin installed can be produced with the following CLI commands:

cordova create barebonesProject com.hangit.barebonesProject BarebonesProject
cd barebonesProject
cordova plugin add ../Hangit_Plugin/iOS_Cordova_Hangit_Plugin
cordova platform add ios
cordova build ios
