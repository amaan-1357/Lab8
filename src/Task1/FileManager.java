package Task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FileManager {
    private List<File> files = new ArrayList<>();
    private int nextFileId = 1;

    public void addFile(String fileName, String owner, byte[] content) {
        File file = new File(nextFileId++, fileName, content.length, owner, content);
        if (!files.contains(file)) {
            files.add(file);
        } else {
            System.out.println("File with the same ID already exists.");
        }
    }

    public List<File> getAvailableFiles() {
        return files;
    }

    public void serializeFiles() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files.dat"))) {
            oos.writeObject(files);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserializeFiles() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files.dat"))) {
            files = (List<File>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}