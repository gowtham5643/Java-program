package placement_training;
import java.io.File;
import java.util.Arrays;

public class FileExtensionFilter {

    public static void main(String[] args) {
        String folderPath = "/path/to/your/folder";
        String extension = "txt"; 

        File folder = new File(folderPath);
        File[] files = getFilesWithExtension(folder, extension);

        System.out.println("Files with extension ." + extension + " in folder " + folderPath + ":");
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
    private static File[] getFilesWithExtension(File folder, String extension) {
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith("." + extension.toLowerCase()));
        if (files != null) {
            Arrays.sort(files); 
        }
        return files;
    }
}
