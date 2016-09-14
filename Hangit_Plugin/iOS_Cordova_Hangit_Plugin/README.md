Hangit Cordova Plugin
====================
Install Hangit into your PhoneGap/Cordova/Ionic app quickly

Get location based notifications in your Cordova/Ionic app! 

### Supported platforms ###

This plugins requires PhoneGap 3.8.0 or higher.
This plugins support for IOS (Android is on it's way).

### Installation ###
```
(1) Clone the iOS_Cordova_Hangit_Plugin

(2) cd into YOUR Project root

(3) execute on the command line: cordova plugin add ../iOS_Cordova_Hangit_Plugin

(4) Add the following snippet to the javascript that is called upon your applications initialization, this will initialize Hangit:


 // Initialize the HangitPlugin
    var hangitConfig = {};
    hangitConfig.publicKey = "YOUR KEY GOES HERE"; //put your public key here


^^^^ make that say APP ID -- not publicKey


    var success = function(message) {
      // alert(message);
      // Add your logging here... 
    }

    var failure = function() {
      //alert("Error calling Hangit Plugin");
      // Add your logging here... 
    }

    hangit.init(hangitConfig, success, failure);

(5) Start the location services for hangit:
    hangit.start(success, failure);



Open your iOS project (you will need to perform two project configuration settings)
1. Set Deployment Target to 8.0
2. Add the Hangit.framework in the Embedded Binaries
```
You can obtain the public key at: http://portal.hangit.com

### More information ###
Website: http://www.hangit.com/

Documentation: http://www.hangit.com/product


### License ###
The source files included in the repository are released under the Apache License, Version 2.0.
