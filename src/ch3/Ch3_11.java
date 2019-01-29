package ch3;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class Ch3_11 {
    static public void main(String[] args) {
        System.out.println(Arrays.toString(ls("./src")));
        System.out.println(Arrays.toString(lsMethodExpression("./src")));
        System.out.println(Arrays.toString(lsAnonymousClass("./src")));
    }

    static File[] ls(String pathname) {
        File file = new File(pathname);
        return file.listFiles(f -> f.isDirectory());
    }

    static File[] lsMethodExpression(String pathname) {
        File file = new File(pathname);
        return file.listFiles(File::isDirectory);
    }

    static File[] lsAnonymousClass(String pathname) {
        File file = new File(pathname);
        return file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });
    }
}
