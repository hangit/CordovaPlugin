//
//  HangitPlugin.h
//
//

#import <Foundation/Foundation.h>
#import <HangitSDK/HangitSDK.h>
#import <UIKit/UIKit.h>

#import <Cordova/CDVPlugin.h>




@interface HangitCordovaPlugin : CDVPlugin <SessionManagerDelegate>

- (void) init:(CDVInvokedUrlCommand*)command;

- (void) start:(CDVInvokedUrlCommand*)command;

- (void) stop:(CDVInvokedUrlCommand*)command;

- (void) deals:(CDVInvokedUrlCommand*)command;

- (void) clear:(CDVInvokedUrlCommand*)command;

// Hangit SessionManager /
@property (nonatomic, strong) SessionManager *sessionManager;


// Hangit sessionKey Property /
@property (nonatomic, retain) NSString * sessionKey;


@end
