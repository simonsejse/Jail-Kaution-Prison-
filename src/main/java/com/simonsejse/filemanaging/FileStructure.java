package com.simonsejse.filemanaging;

import com.simonsejse.Main;
import org.bukkit.Bukkit;

import java.io.*;
import java.util.logging.Level;

public abstract class FileStructure {

    protected File file;

    /**
     *
     * @param main instance of main class
     * @param filePath the path to the file - already has path of plugin folder
     */
    public FileStructure(Main main, String filePath){
        this.file = new File(main.getDataFolder(), filePath);
    }

    /**
     *  Creates file if it does not exists in the first place.
     *  Throws @IOException if file could not be created.
     **/
    public void createFile(){
        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            Bukkit.getLogger().log(Level.SEVERE, "File couldn't be created...");
        }
        //WriteToFile
    }

    /**
     *
     * @param data string to write to the file
     * @throws IOException throws IOException if either file could not be found or could not write to file.
     */
    public void writeToFile(String data) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(this.file);
        BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);
        outputStream.write(data.getBytes());
        outputStream.flush();
    }

    /**
     *
     * @return File
     */
    public File getFile() {
        return this.file;
    }
}
