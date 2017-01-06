Hangit Cordova Plugin
====================
Install Hangit into your PhoneGap/Cordova/Ionic app quickly

Get location based notifications in your Cordova/Ionic app! 

### Supported platforms ###

This plugins requires PhoneGap 3.8.0 or higher.

### Installation and Usage ###
```
(1) Clone the Cordova_Hangit_Plugin

(2) cd into YOUR Project root

(3) execute on the command line: cordova plugin add ../Cordova_Hangit_Plugin

(4) In your javascript, initialize hangit by calling hangit.init()
    Pass your hangit app ID (a key that you obtain by contacting hangit) as the first parameter when calling hangit.init()
    hangit.init("your hangit app ID here", success, failure);

(5) Start the location services for hangit:
    hangit.start(success, failure);

(6) You can manually stop the location services for hangit on demand:
    hangit.stop(success, failure);
    
(7) After initializing you can trigger the wallet by calling hangit.deals:
    hangit.deals(success, failure);


IMPORTANT FOR IOS USERS:
Once you have built your hangit project, you will need to add the HangitSDK.framework as an embedded framework.  Do this by opening the iOS project in xCode (double click the .xcproj file that cordova generates in /platforms/ios/). Select your project target and in the 'General' tab scroll down to the section titled "Embedded Binaries".  Click the + button and in the subsequent dialog find HangitSDK.framework and click "Add"

```
You can obtain your apikey at: http://portal.hangit.com

### More information ###
Website: http://www.hangit.com/

Documentation: http://www.hangit.com/product


### License ###
The source files included in the repository are released under the Apache License, Version 2.0.
