package util;

import java.io.*;

public class FileUtil {

    public static boolean writeObject(Object data, String path) {

        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }

        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(data);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        return false;
    }

    public static Object readObject(String path) {

        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace(System.err);
        }
        return null;
    }
}
