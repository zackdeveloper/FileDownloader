# FileDownloader

1. Install SimpleDownload.java to your projcet 

You can copy and paste (SimpleDownload.java) this java class in your project.

### To Download From URL ###

SimpleDownload.setAppPackname("MyAppName"); // Set name as you want (this is for folder name)
SimpleDownload.setFormatFile(".java"); // Set format file as you want
SimpleDownload.getInstanceDownload().execute("https://example.com/file.java");

Note: Required to allow read and write storage in android 6.0 and up.
