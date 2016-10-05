//
//  HangitPlugin.m
//  http://www.hangit.com/
//

#import "HangitCordovaPlugin.h"
#import <Cordova/CDVViewController.h>


@implementation HangitCordovaPlugin


- (void)init:(CDVInvokedUrlCommand*)command
{
    

    NSString* callbackId = [command callbackId];
    NSString* name = [[[command arguments] objectAtIndex:0] objectForKey:@"hangitAppId"];


    NSString* msg = [NSString stringWithFormat: @"Initialized the Hangit SDK Services..., %@", name];


    self.sessionManager = [SessionManager sharedInstance];
    
    self.sessionManager.delegate = self;
    
    //Local Push Notification To Users
    self.sessionManager.presentNotifications = YES;
    
    //Present Rich Messages To Users
    self.sessionManager.presentOfferView = YES;
    
    //Start a new session
    self.sessionKey = [self.sessionManager startSession:name];
 
    
            CDVPluginResult* result = [CDVPluginResult
                                   resultWithStatus:CDVCommandStatus_OK
                                   messageAsString:msg];

    [self.commandDelegate sendPluginResult:result callbackId:callbackId];
    

    

}


- (void) start:(CDVInvokedUrlCommand*)command
{
    NSString* callbackId = [command callbackId];


    NSString* msg = [NSString stringWithFormat: @"Started the Hangit SDK Services..., %@", @""];
    //We allow for a call to start and stop our Location deals using these 2 methods here to give the user the ability to turn this off if they choose. The startLocation is required to start our SDK and should be included in the initial call here by default

    //Enable Location Deals
    [self.sessionManager startLocation];
    NSLog(@"start");
    
    
            CDVPluginResult* result = [CDVPluginResult
                                   resultWithStatus:CDVCommandStatus_OK
                                   messageAsString:msg];

    [self.commandDelegate sendPluginResult:result callbackId:callbackId];
    

}


- (void) stop:(CDVInvokedUrlCommand*)command
{
    NSString* callbackId = [command callbackId];


    NSString* msg = [NSString stringWithFormat: @"Stopped the Hangit SDK Services..., %@", @""];
    //Disable Location Deals
    [self.sessionManager stopLocation];

    NSLog(@"stop");
    
    
            CDVPluginResult* result = [CDVPluginResult
                                   resultWithStatus:CDVCommandStatus_OK
                                   messageAsString:msg];

    [self.commandDelegate sendPluginResult:result callbackId:callbackId];
    

}


- (void) deals:(CDVInvokedUrlCommand*)command
{
    NSString* callbackId = [command callbackId];


    NSString* msg = [NSString stringWithFormat: @"Deals the Hangit SDK Services..., %@", @""];
    NSLog(@"deals");
    
    [self.sessionManager openWallet];
    
            CDVPluginResult* result = [CDVPluginResult
                                   resultWithStatus:CDVCommandStatus_OK
                                   messageAsString:msg];

    [self.commandDelegate sendPluginResult:result callbackId:callbackId];
    

}


- (void) clear:(CDVInvokedUrlCommand*)command
{
    NSString* callbackId = [command callbackId];
    NSString* msg = [NSString stringWithFormat: @"Cleared the Hangit SDK Services..., %@", @""];
    
    [self.sessionManager clearDevice];
    
    
    NSLog(@"clear");
    
    
            CDVPluginResult* result = [CDVPluginResult
                                   resultWithStatus:CDVCommandStatus_OK
                                   messageAsString:msg];

    [self.commandDelegate sendPluginResult:result callbackId:callbackId];
    

}



@end
