package mxjava.test;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipTest {

    private static final int BUFFER = 8192;

    private static String path = "/Users/wei.li/Downloads/temp";
    private static String originalPath = "/Users/wei.li/Downloads/original_final.apk";
    private static String target = "/Users/wei.li/Downloads/temp1.zip";

    public static void main(String[] args) {
        long count = 204_000;

        System.out.println(count);
        /* unzip */
//        try {
//            unZipAPk(originalPath, path);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /* zip again*/
        //mx zip filePath = /Users/wei.li/Documents/MyDocuments/MXPlayer-Main/MXPlayer/Player_ad/build/outputs/apk/neon_market_v8/debug/ApkGuard_PlayerAd-neon-market-v8-vc1330001435-vn1.39.5.0.debug-/temp/androidsupportmultidexversion.txt , dir = androidsupportmultidexversion.txt , rootPath = /Users/wei.li/Documents/MyDocuments/MXPlayer-Main/MXPlayer/Player_ad/build/outputs/apk/neon_market_v8/debug/ApkGuard_PlayerAd-neon-market-v8-vc1330001435-vn1.39.5.0.debug-/temp

//        try {
//            compressedFile(path, target);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String file = "/Users/wei.li/Documents/MyDocuments/MXPlayer-Main/MXPlayer/Player_ad/build/outputs/apk/neon_market_v8/debug/ApkGuard_PlayerAd-neon-market-v8-vc1330001435-vn1.39.5.0.debug-/temp/androidsupportmultidexversion.txt";
        String root = "/Users/wei.li/Documents/MyDocuments/MXPlayer-Main/MXPlayer/Player_ad/build/outputs/apk/neon_market_v8/debug/ApkGuard_PlayerAd-neon-market-v8-vc1330001435-vn1.39.5.0.debug-/temp";
        int length = root.length();
        int index = file.indexOf(root);
        if (index == 0) {
            String relativePath = file.substring(length + 1);
            System.out.println(relativePath);
        }

    }



    public static void compressedFile(String path, String targetPath) throws IOException {
        File targetFile = new File(targetPath);
        if (!targetFile.exists()) {
            targetFile.createNewFile();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(targetFile);
        ZipOutputStream outputStream = new ZipOutputStream(fileOutputStream);

        createCompressedFile(outputStream, new File(path), "", "META-INF");

//        fileOutputStream.close();
        outputStream.close();
    }


    public static void createCompressedFile(ZipOutputStream out, File file, String dir, String metaName) throws IOException {
        System.out.println("filePath = " + file.getAbsolutePath());
        /* if directory need add next zip path */
        if (file.isDirectory()) {
            String fileName = file.getName();
            File[] list = file.listFiles();
            out.putNextEntry(new ZipEntry(dir+"/"));
            dir = dir.length() == 0 ? "" : dir + "/";

            /* for each */
            for (File item : list) {
                if (metaName.equals(fileName)) {
                    String name = item.getName();
                    if (name.endsWith(".MF") ||
                            name.endsWith(".RSA") ||
                            name.endsWith(".SP")) {
                        continue;
                    }
                }
                createCompressedFile(out, item, dir + item.getName(), metaName);
            }
        } else {
            FileInputStream fis = new FileInputStream(file);

            out.putNextEntry(new ZipEntry(dir));
            // write
            int j = 0;
            byte[] buffer = new byte[1024];
            while ((j = fis.read(buffer))>0) {
                out.write(buffer, 0 , j);
            }
            fis.close();
        }

    }


    public static void unZipAPk(String fileName, String filePath) throws IOException {
        checkDirectory(filePath);
        ZipFile zipFile = new ZipFile(fileName);
        Enumeration emu = zipFile.entries();
        try {
            while (emu.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) emu.nextElement();
                if (entry.isDirectory()) {
                    new File(filePath, entry.getName()).mkdirs();
                    continue;
                }
                BufferedInputStream bis = new BufferedInputStream(zipFile.getInputStream(entry));

                File file = new File(filePath + File.separator + entry.getName());

                File parent = file.getParentFile();
                if (parent != null && (!parent.exists())) {
                    parent.mkdirs();
                }
                FileOutputStream fos = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(fos, BUFFER);

                byte[] buf = new byte[BUFFER];
                int len;
                while ((len = bis.read(buf, 0, BUFFER)) != -1) {
                    fos.write(buf, 0, len);
                }
                bos.flush();
                bos.close();
                bis.close();
            }
        } finally {
            zipFile.close();
        }
    }

    public static boolean checkDirectory(String dir) {
        File dirObj = new File(dir);
        deleteDir(dirObj);

        if (!dirObj.exists()) {
            dirObj.mkdirs();
        }
        return true;
    }


    public static boolean deleteDir(File file) {
        if (file == null || (!file.exists())) {
            return false;
        }
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File files[] = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteDir(files[i]);
            }
        }
        file.delete();
        return true;
    }





}
