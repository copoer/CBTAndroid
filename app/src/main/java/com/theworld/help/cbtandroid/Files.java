package com.theworld.help.cbtandroid;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


import static android.content.Context.MODE_PRIVATE;

public class Files {
    private static final String FILE_NAME = "data.bin";
    private Context c;

    public Files(Context context) {
        c = context;
    }

    public void write(ArrayList<Entry> collection) {
        FileOutputStream fos = null;
        try {
            fos = c.openFileOutput(FILE_NAME, MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(collection);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public ArrayList<Entry> read() {
        FileInputStream fis = null;
        ArrayList<Entry> collection = new ArrayList<>();
        try {
            fis = c.openFileInput(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            collection = (ArrayList<Entry>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return collection;
    }
}
