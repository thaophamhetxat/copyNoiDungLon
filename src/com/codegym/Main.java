package com.codegym;

import java.io.*;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.nio.file.Files;

public class Main {
    private static void  copyFileUsingJava7Files(File source, File dest) throws IOException{
        Files.copy(source.toPath(),dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    private static void copyFileUsingStream(File source , File dest) throws IOException{
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length=is.read(buffer))>0){
                os.write(buffer,0,length);
            }
        }finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER SOURCE SIZE: ");
        String sourcePath = scanner.nextLine();
        System.out.println("ENTER DEST SIZE:");
        String destPath = scanner.nextLine();

        File sourceFile =  new File(sourcePath);
        File destFile = new File(destPath);
        try {
            copyFileUsingJava7Files(sourceFile,destFile);
            System.out.println("copy competed");
        }catch (IOException ioe){
            System.out.println("cant copy that file");
            System.out.println(ioe.getMessage());
        }
    }
}
