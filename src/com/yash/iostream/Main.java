package com.yash.iostream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    final static String PATH = "/home/yash/Desktop/Training_LMS_Tasks/Java-practice/IOStream-File/src/com/yash/iostream/file/";

    public static void main(String[] args){

        String name = "Name : Yash Tailor \n";
        byte[] nameBytes = name.getBytes();

        String profile = "Job Role : Software Developer Engineer \n";
        char profileCharArray[] = profile.toCharArray();
        
        try {
            FileOutputStream fos = new FileOutputStream(PATH + "intro.txt");
            FileInputStream fis = new FileInputStream(PATH + "intro.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);

            // WRITE DATA INTO FILE
            try {
                fos.write(nameBytes);
                int index = 0;
                while (index < profile.length()) {
                    fos.write(profileCharArray[index++]);
                }
            } finally {
                fos.close();
            }

            // READ DATA FROM FILE
            try {
                int value = 0;
                while ((value = bis.read()) != -1) {
                    System.out.print((char) value);
                }
                System.out.println();
            } finally {
                bis.close();
                fis.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        /*
        Comment : TO DELETE ALL FILES
        finally {

            File f = new File(PATH);
            File[] files = f.listFiles();
            for(File file : files){
                file.delete();
            }
        }
        */
    }
}
