/*
 * Copyright (c) 2012, Codename One and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Codename One designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *  
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 * 
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 * Please contact Codename One through http://www.codenameone.com/ if you 
 * need additional information or have any questions.
 */

package com.codename1.intercom;

import com.codename1.intercom.impl.IntercomNative;
import com.codename1.processing.Result;
import com.codename1.system.NativeLookup;
import com.codename1.ui.Display;
import java.util.Map;

/**
 * <p>Intercom is your direct line of communication to every user, right inside your app. Intercom's 
 * in-app messages are up to 10 times more effective than email too! Send the right messages, to the 
 * right users, at exactly the right time.</p>
 * 
 * <p>
 * This is the main point of integration for <a href="https://www.codenameone.com/">Codename One</a>
 * thus allowing universal portability with intercom
 * </p>
 *
 * @author Shai Almog
 */
public class Intercom {
    private static Intercom instance;
    private IntercomNative nativeI;
    
    private Intercom() {}

    /**
     * This method must be invoked before calling get instance in the init(Object) method
     */
    public static void init(String androidKey, String iOSkey, String appId) {
        IntercomNative n = NativeLookup.create(IntercomNative.class);
        if(n != null && n.isSupported()) {
            if(Display.getInstance().getPlatformName().equals("and")) {
                n.initIntercom(androidKey, appId);
            } else {
                n.initIntercom(iOSkey, appId);
            }
            instance = new Intercom();
            instance.nativeI = n;
        }
    }
    
    /**
     * Returns an instance of the class if it's supported in this platform or null if it isn't, this must be invoked 
     * after init is invoked!
     */
    public static Intercom getInstance() {
        return instance;
    }
        
    /**
     * <p>Registers an identified user with Intercom.</p>
     * 
     * <p>In order to keep track of a specific user, you must identify it with a unique user identifier, an 
     * email address, or both. By supplying information like this Intercom provides richer user profiles for 
     * your users. This is a user ID, supplied by you (e.g. from an existing web service for your product) to 
     * represent your user in Intercom, once set it cannot be changed.</p>
     */
    public void registerIdentifiedUser(Registration userRegistration) {
        String map = Result.fromContent(userRegistration.getAttributes()).toString();
        nativeI.registerIdentifiedUser(userRegistration.getUserId(), userRegistration.getEmail(), map);
    }


    /**
     * Registers an unidentified user with Intercom.
     */
    public void registerUnidentifiedUser() {
        nativeI.registerUnidentifiedUser();
    }
    
    /**
     * <p>Clears all data from the Intercom SDK.</p>
     * <p>Reset is used to reset all local caches and user data the Intercom SDK has created. Use this at a 
     * time when you wish to log a user out of your app or change a user. Once called, the SDK will no longer 
     * communicate with Intercom until a further registration is made.</p>
     */
    public void reset() {
        nativeI.reset();
    }
    
    /**
     * <p>Sets the secure hash and data to be used for Secure Mode.</p>
     * 
     * <p>Secure Mode helps to make sure that conversations between you and your users are kept private and that 
     * one user can't impersonate another. In Secure Mode the SDK will sign all requests going to the Intercom 
     * servers with tokens. It requires your mobile application to have its own server which authenticates the app's 
     * users and which can store a secret. More information on secure mode can be found here.</p>
     * 
     * <p>This should be called before any user registration takes place.</p>
     */
    public void setSecureMode(String secureHash, String secureData) {
        nativeI.setSecureMode(secureHash, secureData);
    }

    /**
     * Updates a user in Intercom.
     */
    public void updateUser(Map<java.lang.String,?> attributes) {
        String map = Result.fromContent(attributes).toString();
        nativeI.updateUser(map);
    }
    
    /**
     * Logs an event with the given name
     * @param name the name of the event
     */
    public void logEvent(String name) {
        nativeI.logEvent(name);
    }

    /**
     * Logs an event with a given name and some metadata.
     */
    public void logEvent(String name, Map<java.lang.String,?> metaData) {
        String map = Result.fromContent(metaData).toString();
        nativeI.logEventWithMetadata(name, map);
    }

    /**
     * Displays the Messenger.
     */
    public void displayMessenger() {
        nativeI.displayMessenger();
    }

    /**
     * Dismisses the Intercom Messenger if it is on screen.
     */
    public void hideMessenger() {
        nativeI.hideMessenger();
    }

    /**
     * Displays the message composer.
     */
    public void displayMessageComposer() {
        nativeI.displayMessageComposer();
    }

    /**
     * Displays the message composer.
     */
    public void displayMessageComposer(String initialMessage) {
        nativeI.displayMessageComposerWithMessage(initialMessage);
    }

    /**
     * Displays the conversations list.
     */
    public void displayConversationsList() {
        nativeI.displayConversationsList();
    }
    
    /**
     * Gets the number of unread conversations for a user.
     */
    public int getUnreadConversationCount() {
        return nativeI.getUnreadConversationCount();
    }

    /**
     * Toggles visibility of the launcher view.
     */
    public void setLauncherVisibility(boolean visibility) {
        nativeI.setLauncherVisibility(visibility);
    }

    /**
     * Toggles visibility of in-app messages.
     */
    public void setInAppMessageVisibility(boolean visibility) {
        nativeI.setInAppMessageVisibility(visibility);
    }
}
