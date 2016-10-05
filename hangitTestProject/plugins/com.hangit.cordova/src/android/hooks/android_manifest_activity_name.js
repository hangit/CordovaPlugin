
 module.exports = function(context) {
  console.log("in post hook");
   var fs = context.requireCordovaModule('fs'),
     path = context.requireCordovaModule('path');
 
   var platformRoot = path.join(context.opts.projectRoot, 'platforms/android');
 
 
   var manifestFile = path.join(platformRoot, 'AndroidManifest.xml');
 
   if (fs.existsSync(manifestFile)) {
      console.log("manifest Exisits");
 
     fs.readFile(manifestFile, 'utf8', function (err,data) {
       if (err) {
         throw new Error('Unable to find AndroidManifest.xml: ' + err);
       }
 
       var appClass = 'MainActivityHangitExt';
 
       if (data.indexOf(appClass) == -1) {
 
        console.log("MainActivityHangitExt needs to be added");
         var result = data.replace(/android:name="MainActivity"/g, 'android:name="com.hangit.' + appClass + '"');
 
          console.log("result is "+result);
         fs.writeFile(manifestFile, result, 'utf8', function (err) {
            console.log("write to file callback err "+err);
           if (err) throw new Error('Unable to write into AndroidManifest.xml: ' + err);
         });
       }
     });
   }
 };