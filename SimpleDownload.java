package com.imersoftware.simpledownload;

import android.os.AsyncTask;
import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class SimpleDownload extends AsyncTask<String, String, String> {

    private static SimpleDownload simpleDownload;
    private static String appPackname;
    private static String formatFile;

    public static SimpleDownload getInstanceDownload() {
       simpleDownload = new SimpleDownload();
       return simpleDownload;
    }


    @Override
    protected String doInBackground(final String... strings) {
        final File folderFile = new File("/storage/emulated/0/"+appPackname);
        final File fileToDownload = new File("/storage/emulated/0/"+appPackname+".ini");


        // If folder not exist create folder

        if(!folderFile.exists()) {
            folderFile.mkdir();
        }


        downloadFile(strings[0], fileToDownload); 
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    private static void downloadFile(final String url, final File outputFile) {
        try {
            final URL u = new URL(url);
            final URLConnection conn = u.openConnection();
            final int contentLength = conn.getContentLength();

            final DataInputStream stream = new DataInputStream(u.openStream());

            final byte[] buffer = new byte[contentLength];
            stream.readFully(buffer);
            stream.close();

            final DataOutputStream fos = new DataOutputStream(new FileOutputStream(outputFile));
            fos.write(buffer);
            fos.flush();
            fos.close();
        } catch(final FileNotFoundException e) {
        } catch (final IOException e) {
        }
    }

    public static void setAppPackname(final String appPackname) {
        SimpleDownload.appPackname = appPackname;
    }

    public static void setFormatFile(final String formatFile) {
        SimpleDownload.formatFile = formatFile;
    }
  
}
