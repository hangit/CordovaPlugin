#import "AppDelegate+hangit.h"

#import <Cordova/CDVPlugin.h>

@implementation AppDelegate (hangit)

- (void)application:(UIApplication *)application didReceiveLocalNotification:(UILocalNotification *)notification
{    
    [[NSNotificationCenter defaultCenter] postNotificationName:CDVLocalNotification object:notification];

    [[NSNotificationCenter defaultCenter] postNotificationName:UIApplicationDidFinishLaunchingNotification object:notification];
}

@end
