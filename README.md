# Codename One Intercom Support

[Intercom.io](http://www.intercom.io) allows you to track & support users across multiple channels. At [Codename One](https://www.codenameone.com) we use it for support and customer communication so it's fitting we would add it to our apps so we can communicate better with developers in our demos as well.

This is modeled closely to the Android API for Intercom but we also derived some inspiration from the Cordova support. Currently push with intercom still isn't tested but it is something we hope to add as we move forward.

The test app included is a bit simplistic but the basic usage is:

````java
Intercom.init("AndroidAppKey", "IosAppKey", "AppId");
if(Intercom.getInstance() != null) {
   Intercom.getInstance().registerIdentifiedUser(Registration.create().withEmail(usersEmail));
}
````

You can now start sending events and opening the messenger using standard API's such as:

````java
if(Intercom.getInstance() != null) {
   Intercom.getInstance().displayConversationsList();
}
````

Currently only Android & iOS are supported as Intercom doesn't support Windows. We might do JavaScript integration for other platforms as a fallback if there is a technical possibility or demand for that.
