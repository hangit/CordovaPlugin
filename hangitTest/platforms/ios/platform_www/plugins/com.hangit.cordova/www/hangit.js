cordova.define("com.hangit.cordova.Hangit", function(require, exports, module) {

    var exec = require('cordova/exec');

    var hangit = {
        init:function(arguments, successCallback, failCallback) {
            exec(successCallback, failCallback, "HangitCordovaPlugin", "init", [arguments]);
        },
        start:function( successCallback, failCallback) {
            exec(successCallback, failCallback, "HangitCordovaPlugin", "start", []);
        },
        stop:function( successCallback, failCallback) {
            exec(successCallback, failCallback, "HangitCordovaPlugin", "stop", []);
        },
        deals:function( successCallback, failCallback) {
            exec(successCallback, failCallback, "HangitCordovaPlugin", "deals", []);
        },
        clear:function( successCallback, failCallback) {
            exec(successCallback, failCallback, "HangitCordovaPlugin", "clear", []);
        }
    };

	module.exports = hangit;


});
