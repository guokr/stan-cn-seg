package com.guokr.nlp.seg;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.guokr.util.MultipleGZIPOutputStream;

public class SegMigrate {

    public static void main(String[] args) {
        try {
            MultipleGZIPOutputStream mgzo = new MultipleGZIPOutputStream(args[1]);
            GZIPOutputStream gos = new GZIPOutputStream(mgzo);
            GZIPInputStream fis = new GZIPInputStream(new FileInputStream(args[0]));
            while (fis.available() != 0) {
                gos.write(fis.read());
            }
            fis.close();
            gos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
