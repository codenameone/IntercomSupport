#import <Foundation/Foundation.h>

@interface com_codename1_intercom_impl_IntercomNativeImpl : NSObject {
}

-(void)reset;
-(void)setSecureMode:(NSString*)param param1:(NSString*)param1;
-(void)hideMessenger;
-(void)logEvent:(NSString*)param;
-(void)initIntercom:(NSString*)param param1:(NSString*)param1;
-(void)displayMessageComposer;
-(void)logEventWithMetadata:(NSString*)param param1:(NSString*)param1;
-(void)displayConversationsList;
-(void)setLauncherVisibility:(BOOL)param;
-(void)updateUser:(NSString*)param;
-(void)displayMessenger;
-(void)registerUnidentifiedUser;
-(void)setInAppMessageVisibility:(BOOL)param;
-(void)registerIdentifiedUser:(NSString*)param param1:(NSString*)param1 param2:(NSString*)param2;
-(void)displayMessageComposerWithMessage:(NSString*)param;
-(int)getUnreadConversationCount;
-(BOOL)isSupported;
@end
