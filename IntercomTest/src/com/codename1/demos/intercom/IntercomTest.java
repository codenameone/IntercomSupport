package com.codename1.demos.intercom;


import com.codename1.components.FloatingHint;
import com.codename1.components.SpanLabel;
import com.codename1.intercom.Intercom;
import com.codename1.intercom.Registration;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.io.Preferences;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import java.io.IOException;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class IntercomTest {

    private Form current;
    private Resources theme;

    public void init(Object context) {
        String appId = Preferences.get("appId", null);
        if(appId != null) {
            String andKey = Preferences.get("andKey", null);
            String iosKey = Preferences.get("iosKey", null);
            Intercom.init(andKey, iosKey, appId);
        }
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature, uncomment if you have a pro subscription
        Log.bindCrashProtection(true);
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
        if(Preferences.get("appId", null) == null) {
            configureIntercom();
        } else {
            showMainUI();
        }
    }
    
    public void showMainUI() {
        Form m = new Form("Test Intercom", BoxLayout.y());
        Button displayConversationsList = new Button("Display Conversations List");
        displayConversationsList.addActionListener(e -> Intercom.getInstance().displayConversationsList());
        Button displayMessageComposer = new Button("Display Message Composer");
        displayMessageComposer.addActionListener(e -> Intercom.getInstance().displayMessageComposer());
        Button displayMessenger = new Button("Display Messenger");
        displayMessenger.addActionListener(e -> Intercom.getInstance().displayMessenger());
        Button hideMessenger = new Button("Hide Messenger");
        hideMessenger.addActionListener(e -> Intercom.getInstance().hideMessenger());
        TextField event = new TextField("Event Text", "Event", 15, TextField.ANY);
        Button logEvent = new Button("Log Event");
        logEvent.addActionListener(e -> Intercom.getInstance().logEvent(event.getText()));
        Button registerUnidentifiedUser = new Button("Register Unidentified User");
        registerUnidentifiedUser.addActionListener(e -> Intercom.getInstance().registerUnidentifiedUser());
        TextField user = new TextField("", "E-Mail", 15, TextField.EMAILADDR);
        Button registerIdentifiedUser = new Button("Log Event");
        registerIdentifiedUser.addActionListener(e -> Intercom.getInstance().registerIdentifiedUser(Registration.create().withEmail(user.getText())));
        CheckBox setInAppMessageVisibility = new CheckBox("In App Message Visibility");
        setInAppMessageVisibility.addActionListener(e -> Intercom.getInstance().setInAppMessageVisibility(setInAppMessageVisibility.isSelected()));
        
        m.add(new SpanLabel("You have " + Intercom.getInstance().getUnreadConversationCount() + " unread conversations")).
                add(displayConversationsList).
                add(displayMessageComposer).
                add(displayMessenger).
                add(hideMessenger).
                add(GridLayout.encloseIn(2, event, logEvent)).
                add(registerUnidentifiedUser).
                add(registerIdentifiedUser).
                add(setInAppMessageVisibility);
        m.show();
        
    }

    public void configureIntercom() {
        Form configure = new Form("Configure", BoxLayout.y());
        TextField andKey = new TextField("", "Android Key", 20, TextField.ANY);
        TextField iosKey = new TextField("", "iOS Key", 20, TextField.ANY);
        TextField appId = new TextField("", "App ID", 20, TextField.ANY);
        Button apply = new Button("Apply");
        configure.add(new FloatingHint(andKey)).
                add(new FloatingHint(iosKey)).
                add(new FloatingHint(appId)).
                add(apply);
        apply.addActionListener(e -> {
            Preferences.set("andKey", andKey.getText());
            Preferences.set("iosKey", iosKey.getText());
            Preferences.set("appId", appId.getText());
            Intercom.init(andKey.getText(), iosKey.getText(), appId.getText());
            if(Intercom.getInstance() != null) {
                Intercom.getInstance().reset();
            }
            showMainUI();
        });
        configure.show();
    }
    
    public void stop() {
        current = Display.getInstance().getCurrent();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = Display.getInstance().getCurrent();
        }
    }
    
    public void destroy() {
    }

}
