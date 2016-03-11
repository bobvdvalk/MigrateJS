package nl.mawoo.migratejs.extend.filemanager;

import nl.mawoo.migratejs.converter.JsonConverter;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Joshua on 5-3-2016.
 */
public class FilemanagerHandler {

    /**
     * Lists all the files in a directory
     * @param directoryPath Path to the directory.
     */
    public List<File> listFiles(String directoryPath) {
        return new ArrayList<File>(Arrays.asList(new File(directoryPath).listFiles()));
    }

    public String listFilesString(String directoryPath) {
        JsonConverter jc = new JsonConverter();
        return jc.listToJson(Arrays.asList(new File(directoryPath).listFiles()));
    }

    /**
     * List all the files in a directory with a certain extension.
     * @param directoryPath Path to the directory.
     * @param extensions The extension of the files listed.
     * @return
     */
    public List<File> listFiles(String directoryPath, String extensions) {
        List<File> output = new ArrayList<>();
        String extensionList[] = extensions.replaceAll("[ .]", "").split(",");
        for(File f : new File(directoryPath).listFiles()) {
            for(String extension : extensionList) {
                if (f.getName().endsWith(extension)) {
                    output.add(f);
                    continue;
                }
            }
        }
        return output;
    }

    /**
     * Lists all the directories in a directory.
     * @param directoryPath Path to the directory.
     * @return
     */
    public List<File> listDirectories(String directoryPath) {
        System.out.println("echooooo222!");
        List<File> output = new ArrayList<>();
        for(File file : new File(directoryPath).listFiles()) {
            if(file.isDirectory())
                output.add(file);
        }
        return output;
    }

    /**
     * Moves a file from the source to the target location.
     * @param source Source location
     * @param target Target location
     * @param copyOption CopyOptions {StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.ATOMIC_MOVE, LinkOption.NOFOLLOW_LINKS}
     * @throws IOException
     */
    public void moveFile(String source, String target, CopyOption copyOption) throws IOException {
        if(new File(source).exists())
            Files.move(Paths.get(source), Paths.get(target), copyOption);
    }

    /**
     * Moves a file from the source to the target location.
     * @param source Source location
     * @param target Target location
     * @throws IOException
     */
    public void moveFile(String source, String target) throws IOException {
        if(new File(source).exists())
            Files.move(Paths.get(source), Paths.get(target));
    }

    /**
     * Copies a file from the source to the target location.
     * @param source Source location
     * @param target Target location
     * @param copyOption CopyOptions {StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.ATOMIC_MOVE, LinkOption.NOFOLLOW_LINKS}
     * @throws IOException
     */
    public void copyFile(String source, String target, CopyOption copyOption) throws IOException {
        if(new File(source).exists())
            Files.copy(Paths.get(source), Paths.get(target), copyOption);
    }

    /**
     * Copies a file from the source to the target location.
     * @param source Source location
     * @param target Target location
     * @throws IOException
     */
    public void copyFile(String source, String target) throws IOException {
        Files.copy(Paths.get(source), Paths.get(target));
    }

    /**
     * Creates a directory at the target location. This will also create all parent directories if needed.
     * @param target Target location of the to-be created directory.
     * @throws IOException
     */
    public void createDirectory(String target) throws IOException {
        Files.createDirectories(Paths.get(target));
    }

}
