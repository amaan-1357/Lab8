package Task1;

import java.util.List;

public class Main_Task1 {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();

        fileManager.addFile("file1.txt", "User1", "ADASDASFWEFWDSFCSDJFNDFJNDSJNCDSVDS".getBytes());
        fileManager.addFile("file2.txt", "User2", "CNIANVRIAMVLTSNKEIQNCNGKENXNF".getBytes());

        fileManager.serializeFiles();
        fileManager.deserializeFiles();

        List<File> availableFiles = fileManager.getAvailableFiles();
        for (File file : availableFiles) {
            System.out.println("File ID: " + file.getFileId());
            System.out.println("File Name: " + file.getFileName());
            System.out.println("Size: " + file.getSize());
            System.out.println("Owner: " + file.getOwner());
            System.out.println("Content: " + new String(file.getContent()));
        }
    }
}