# FileDownloader

### To download from url ###

SimpleDownload.setAppPackname("MyAppName"); // Set name as you want (this is for folder name)
SimpleDownload.setFormatFile(".java"); // Set format file as you want
SimpleDownload.getInstanceDownload().execute("https://example.com/file.java");

Note: Required to allow read and write storage in android 6.0 and up.
