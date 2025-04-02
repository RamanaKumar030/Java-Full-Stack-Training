package DAY7;

import java.io.*;
import java.util.*;

class BackupSystem {
    private static final String BACKUP_DIR = "backup/";
    private static final String META_FILE = "backup_metadata.dat";

    static void backup(String dirPath) {
        if (dirPath == null) {
            System.out.println("Error: Directory path is null.");
            return;
        }
        File src = new File(dirPath);
        if (!src.exists() || !src.isDirectory()) {
            System.out.println("Error: Invalid directory path.");
            return;
        }

        List<String[]> metadata = new ArrayList<>();
        new File(BACKUP_DIR).mkdirs();

        File[] files = src.listFiles();
        if (files == null) {
            System.out.println("Error: No files found in directory.");
            return;
        }

        for (File file : files) {
            File dest = new File(BACKUP_DIR + file.getName());
            copy(file, dest);
            metadata.add(new String[]{file.getName(), String.valueOf(file.length()), String.valueOf(file.lastModified())});
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(META_FILE))) {
            out.writeObject(metadata);
        } catch (Exception e) {
            System.out.println("Error: Unable to write metadata.");
        }
    }

    static void recover() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(META_FILE))) {
            List<String[]> metadata = (List<String[]>) in.readObject();
            for (String[] data : metadata) {
                File sourceFile = new File(BACKUP_DIR + data[0]);
                if (sourceFile.exists()) {
                    copy(sourceFile, new File(data[0]));
                } else {
                    System.out.println("Error: Backup file missing - " + data[0]);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: Unable to read metadata.");
        }
    }

    private static void copy(File src, File dest) {
        try (FileInputStream in = new FileInputStream(src); FileOutputStream out = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) > 0) out.write(buffer, 0, len);
        } catch (Exception e) {
            System.out.println("Error: File copy failed for " + src.getName());
        }
    }

    public static void main(String[] args) {
        backup("test_dir"); // Ensure this folder exists before running
        recover();
    }
}
