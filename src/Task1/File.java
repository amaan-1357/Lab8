package Task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class File implements Serializable {
    private static final long serialVersionUID = 1L;
    private int fileId;
    private String fileName;
    private long size;
    private String owner;
    private byte[] content;

    public File(int fileId, String fileName, long size, String owner, byte[] content) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.size = size;
        this.owner = owner;
        this.content = content;
    }


    public int getFileId() {
        return fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public long getSize() {
        return size;
    }

    public String getOwner() {
        return owner;
    }

    public byte[] getContent() {
        return content;
    }
}