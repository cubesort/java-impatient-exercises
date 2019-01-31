package ch3;

import java.io.File;
import java.util.Arrays;

public class Ch3_12 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(lsFilesOfExtension("./src/ch3", "java")));
    }

    static String[] lsFilesOfExtension(String pathname, String ext) {
        File file = new File(pathname);

        return file.list((File dir, String name) -> {
            String[] nameArr = name.split("\\.");
            if (nameArr.length == 0) {
                return false;
            }

            return nameArr[nameArr.length - 1].equals(ext);
        });
    }
}
