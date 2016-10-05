cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    {
        "id": "com.hangit.cordova.Hangit",
        "file": "plugins/com.hangit.cordova/www/hangit.js",
        "pluginId": "com.hangit.cordova",
        "clobbers": [
            "hangit"
        ]
    }
];
module.exports.metadata = 
// TOP OF METADATA
{
    "cordova-plugin-whitelist": "1.3.0",
    "com.hangit.cordova": "1.9.0"
};
// BOTTOM OF METADATA
});