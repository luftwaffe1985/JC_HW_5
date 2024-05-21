import java.io.File;
import java.io.IOException;

public class Program {

    public static void main(String[] args) {

        PlaceAllFiles PlaceAllFiles = new PlaceAllFiles();
        String sourceDirName = "storage_directory";
        String backupDirName = "backup_catalog";

        try {
            PlaceAllFiles.createFiles(sourceDirName); // Creates catalog and fills it in
        } catch (IOException e) {
            System.out.println(e);
        }

        File directory = new File(sourceDirName); // Creates backup catalog
        try {
            PlaceAllFiles.backUpDir(directory, backupDirName);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}