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

import java.util.HashMap;
import java.util.Map;

/**
 *<p>The Registration object is used for registering identified users with Intercom.</p>
 * <p>This is an example of how to register a user with a user ID</p>
 * 
 * {@code Intercom.client().registerIdentifiedUser(Registration.create().withUserId("12345")); }
 *
 * 
 * @author Shai Almog
 */
public class Registration {
    private HashMap<String,Object> attributes = new HashMap<>();
    private String email;
    private String userId;
    
    private Registration() {}
    
    /**
     * Factory to create a new, empty Registration object.
     */
    public static Registration create() {
        return new Registration();
    }

    public Map<String,Object> getAttributes() {
        return attributes;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getUserId() {
        return userId;
    }
    
    /**
     * Add an email address to this registration.
     */
    public Registration withEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Add a map of user attributes to this registration.
     */
    public Registration withUserAttributes(Map<java.lang.String,java.lang.Object> attributes) {
        this.attributes.putAll(attributes);
        return this;
    }
    
    /**
     * Add a unique user identifier to this registration.
     */
    public Registration withUserId(java.lang.String userId) {
        this.userId = userId;
        return this;
    }
}
