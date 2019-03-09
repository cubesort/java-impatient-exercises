package ch6;

import java.util.ArrayList;

public class Ch6_14 {
    public static void main(String[] args) {

    }

    public static <T extends AutoCloseable> void closeAll(ArrayList<T> arr) throws Exception {
        Exception ex = null;
        for (T item : arr) {
            try {
                item.close();
            } catch (Exception e) {
                ex = new Exception(e.getMessage(), ex);
            }
        }

        if (ex != null) {
            throw ex;
        }
    }
}
