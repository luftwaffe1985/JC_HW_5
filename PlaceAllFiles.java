import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class PlaceAllFiles { // Text class for files
    private static final int count = 8;
    File sourceDir;

    public boolean createDir(String dirName) { // Catalog
        sourceDir = new File(dirName);
        if (sourceDir.exists())
            sourceDir.delete();
        if (sourceDir.mkdir()) {
            return true;
        }
        return false;
    }

    public void createFiles(String dirName) throws IOException { // Generates count for files in the catalog dirName
        if (createDir(dirName)) {
            System.out.println("Создан каталог: " + dirName);
            String[] fileNames = new String[count];
            for (int i = 0; i < fileNames.length; i++) {
                fileNames[i] = "file_" + i + ".txt";
                try (FileOutputStream fileOutputStream = new FileOutputStream(dirName + "/" + fileNames[i])) {
                    fileOutputStream
                            .write(GenerateText.generateSymbols((i + 1) * (i + 1)).getBytes(StandardCharsets.UTF_8));
                    System.out.println("Created file: " + fileNames[i]);
                }
            }
        }
    }

    public void backUpDir(File dir, String backUpName) throws IOException { // Generates catalog backup
        if (createDir(backUpName)) {
            File[] files = dir.listFiles();
            System.out.println("Copied to catalog " + backUpName);
            for (int i = 0; i < files.length; i++) {
                try (FileOutputStream fileOutputStream = new FileOutputStream(backUpName + "/" + files[i].getName())) {
                    int c;
                    try (FileInputStream fileInputStream = new FileInputStream(files[i])) {
                        while ((c = fileInputStream.read()) != -1) {
                            fileOutputStream.write(c);
                        }
                        System.out.println("Copied file " + files[i].getName());
                    }
                }
            }
        }
    }
}