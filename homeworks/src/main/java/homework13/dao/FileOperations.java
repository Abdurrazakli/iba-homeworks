package homework13.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperations<T> {
    private File file;
    public FileOperations(String path) {
        this.file = new File(path);
    }
    public List<T> read() throws FileNotFoundException, IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            Object dataReaded = ois.readObject();
            List<T> list = (ArrayList<T>)(dataReaded);
            return list;
        }
    }
    public boolean write(List<T> data) throws FileNotFoundException, IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            oos.writeObject(data);
            return true;
        }
    }
}
