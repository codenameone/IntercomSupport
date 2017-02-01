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

package com.codename1.intercom.impl;

import com.codename1.intercom.Registration;
import com.codename1.system.NativeInterface;

/**
 * Implementation code, not for external use
 *
 * @author Shai Almog
 * @deprecated this interface is for internal usage only use the Intercom class instead
 */
public interface IntercomNative extends NativeInterface {
    public void initIntercom(String apiKey, String appId);
    public void registerIdentifiedUser(String userId, String email, String attributesJson);
    public void registerUnidentifiedUser();
    public void reset();
    public void setSecureMode(String secureHash, String secureData);
    public void updateUser(String attributesJson);
    public void logEvent(String name);
    public void logEventWithMetadata(String name, String metaJson);
    public void displayMessenger();
    public void hideMessenger();
    public void displayMessageComposer();
    public void displayMessageComposerWithMessage(String initialMessage);
    public void displayConversationsList();
    public int getUnreadConversationCount();
    public void setLauncherVisibility(boolean visibility);
    public void setInAppMessageVisibility(boolean visibility);
}
