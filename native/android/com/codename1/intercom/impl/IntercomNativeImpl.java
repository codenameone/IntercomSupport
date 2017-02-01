package com.codename1.intercom.impl;

import com.codename1.impl.android.AndroidNativeUtil;
import com.codename1.io.JSONParser;
import com.codename1.util.regex.StringReader;
import io.intercom.android.sdk.*;
import io.intercom.android.sdk.identity.Registration;
import java.util.Map;
import java.io.IOException;

public class IntercomNativeImpl {
    public void initIntercom(String param, String param1) {
        Intercom.initialize(AndroidNativeUtil.getActivity().getApplication(), param, param1);
    }

    public void reset() {
        Intercom.client().reset();
    }

    public void registerIdentifiedUser(String param, String param1, String param2) {
        Registration r = Registration.create();
        if(param != null) {
            r = r.withUserId(param);
        }
        if(param1 != null) {
            r = r.withEmail(param1);
        }
        try {
            if(param2 != null) {
                JSONParser p = new JSONParser();
                Map<java.lang.String,java.lang.Object> m = p.parseJSON(new StringReader(param2));
                r  = r.withUserAttributes(m);
            }
        } catch(IOException err) {
            // won't happen
            err.printStackTrace();
        }
        Intercom.client().registerIdentifiedUser(r);
    }

    public void logEvent(String param) {
        Intercom.client().logEvent(param);
    }

    public int getUnreadConversationCount() {
        return Intercom.client().getUnreadConversationCount();
    }

    public void setInAppMessageVisibility(boolean param) {
        if(param) {
            Intercom.client().setInAppMessageVisibility(Intercom.Visibility.VISIBLE);
        } else {
            Intercom.client().setInAppMessageVisibility(Intercom.Visibility.GONE);
        }
    }

    public void displayConversationsList() {
        Intercom.client().displayConversationsList();
    }

    public void setSecureMode(String param, String param1) {
        Intercom.client().setSecureMode(param, param1);
    }

    public void displayMessageComposerWithMessage(String param) {
        Intercom.client().displayMessageComposer(param);
    }

    public void logEventWithMetadata(String param, String param1) {
        try {
            JSONParser p = new JSONParser();
            Map<java.lang.String,java.lang.Object> m = p.parseJSON(new StringReader(param1));
            Intercom.client().logEvent(param, m);
        } catch(IOException err) {
            // won't happen
            err.printStackTrace();
        }
    }

    public void setLauncherVisibility(boolean param) {
        if(param) {
            Intercom.client().setLauncherVisibility(Intercom.Visibility.VISIBLE);
        } else {
            Intercom.client().setLauncherVisibility(Intercom.Visibility.GONE);
        }
    }

    public void registerUnidentifiedUser() {
        Intercom.client().registerUnidentifiedUser();
    }

    public void hideMessenger() {
        Intercom.client().hideMessenger();
    }

    public void displayMessageComposer() {
        Intercom.client().displayMessageComposer();
    }

    public void updateUser(String param) {
        try {
            JSONParser p = new JSONParser();
            Map<java.lang.String,java.lang.Object> m = p.parseJSON(new StringReader(param));
            Intercom.client().updateUser(m);
        } catch(IOException err) {
            // won't happen
            err.printStackTrace();
        }
    }

    public void displayMessenger() {
        Intercom.client().displayMessenger();
    }

    public boolean isSupported() {
        return true;
    }

}
