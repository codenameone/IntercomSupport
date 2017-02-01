#import "com_codename1_intercom_impl_IntercomNativeImpl.h"

#define __IPHONE_OS_VERSION_MIN_REQUIRED_TEMP __IPHONE_OS_VERSION_MIN_REQUIRED
#undef __IPHONE_OS_VERSION_MIN_REQUIRED
#define __IPHONE_OS_VERSION_MIN_REQUIRED __IPHONE_8_0

#import <Intercom/Intercom.h>

#undef __IPHONE_OS_VERSION_MIN_REQUIRED
#define __IPHONE_OS_VERSION_MIN_REQUIRED __IPHONE_OS_VERSION_MIN_REQUIRED_TEMP


@implementation com_codename1_intercom_impl_IntercomNativeImpl

-(void)reset{
    dispatch_async(dispatch_get_main_queue(), ^{
        [Intercom reset];
    });
}

-(void)setSecureMode:(NSString*)param param1:(NSString*)param1{
    dispatch_async(dispatch_get_main_queue(), ^{
        [Intercom setHMAC:param data:param1];
    });
}

-(void)hideMessenger{
    dispatch_async(dispatch_get_main_queue(), ^{
        [Intercom setMessagesHidden:YES];
    });
}

-(void)logEvent:(NSString*)param{
    dispatch_async(dispatch_get_main_queue(), ^{
        [Intercom logEventWithName:param];
    });
}

-(void)initIntercom:(NSString*)param param1:(NSString*)param1{
    dispatch_async(dispatch_get_main_queue(), ^{
        [Intercom setApiKey:param forAppId:param1];
    });
}

-(void)displayMessageComposer{
    dispatch_async(dispatch_get_main_queue(), ^{
        [Intercom presentMessageComposer];
    });
}

-(void)logEventWithMetadata:(NSString*)param param1:(NSString*)param1{
    dispatch_async(dispatch_get_main_queue(), ^{
        NSData *data = [param1 dataUsingEncoding:NSUTF8StringEncoding];
        NSDictionary* dic = [NSJSONSerialization JSONObjectWithData:data options:0 error:nil];
        [Intercom logEventWithName:param metaData:dic];
    });
}

-(void)displayConversationsList{
    dispatch_async(dispatch_get_main_queue(), ^{
        [Intercom presentConversationList];
    });
}

-(void)setLauncherVisibility:(BOOL)param{
    dispatch_async(dispatch_get_main_queue(), ^{
        [Intercom setLauncherVisible:YES];
    });
}

-(void)updateUser:(NSString*)param{
    dispatch_async(dispatch_get_main_queue(), ^{
        NSData *data = [param dataUsingEncoding:NSUTF8StringEncoding];
        NSDictionary* dic = [NSJSONSerialization JSONObjectWithData:data options:0 error:nil];
        [Intercom updateUserWithAttributes:dic];
    });
}

-(void)displayMessenger{
    dispatch_async(dispatch_get_main_queue(), ^{
        [Intercom presentMessageComposer];
    });
}

-(void)registerUnidentifiedUser{
    dispatch_async(dispatch_get_main_queue(), ^{
        [Intercom registerUnidentifiedUser];
    });
}

-(void)setInAppMessageVisibility:(BOOL)param{
    dispatch_async(dispatch_get_main_queue(), ^{
        [Intercom setInAppMessagesVisible:param];
    });
}

-(void)registerIdentifiedUser:(NSString*)param param1:(NSString*)param1 param2:(NSString*)param2{
    dispatch_async(dispatch_get_main_queue(), ^{
        if (param.length > 0 && param1.length > 0) {
            [Intercom registerUserWithUserId:param email:param1];
        } else if (param.length > 0) {
            [Intercom registerUserWithUserId:param];
        } else if (param1.length > 0) {
            [Intercom registerUserWithEmail:param1];
        }
        if(param2 != nil) {
            [self updateUser:param2];
        }
    });
}

-(void)displayMessageComposerWithMessage:(NSString*)param{
    dispatch_async(dispatch_get_main_queue(), ^{
        [Intercom presentMessageComposerWithInitialMessage:param];
    });
}

-(int)getUnreadConversationCount{
    __block NSUInteger count;
    dispatch_sync(dispatch_get_main_queue(), ^{
        count = [Intercom unreadConversationCount];
    });
    return count;
}

-(BOOL)isSupported{
    return YES;
}

@end
