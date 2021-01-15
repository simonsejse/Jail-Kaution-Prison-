package com.simonsejse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simonsejse.filemanaging.ConfigFile;
import com.simonsejse.filemanaging.FileStructure;
import com.simonsejse.managing.Block;
import com.simonsejse.managing.JailManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;

public final class Main extends JavaPlugin {


    /* Properties */
    private static String JSON_SCHEMATICS_URL = "https://raw.githubusercontent.com/simonsejse/jail-json-scheme/main/README.md?token=AE6ARBQIJAJZRXVNPH63JQK76PSAA";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private FileStructure configFile;
    private JailManager manager;


    /**
     * Runs on startup
     */
    @Override
    public void onEnable() {
        this.manager = new JailManager();

        this.configFile = new ConfigFile(this, "config.json");
        this.establishFiles();
        this.loadMaps();
    }

    /**
     * Runs on closure
     */
    @Override
    public void onDisable() {

    }


    /**
     *
     * @return a String containing the whole config.json data
     * @throws IOException
     */
    public String getJsonSchematicToString() throws IOException {
        StringBuilder json = new StringBuilder();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(getJsonSchematicUrl().openStream());
        int c;
        while ((c = bufferedInputStream.read()) != -1){
            json.append((char)c);
        }
        return json.toString();
    }

    /**
     * Create files method
     */
    private void establishFiles(){
        if (!configFile.getFile().exists()){
            this.configFile.createFile();
            try {
                this.configFile.writeToFile(getJsonSchematicToString());
            } catch (IOException e) {
                Bukkit.getLogger().log(Level.SEVERE, "There was a problem trying to write to the config.json file");
            }
        }
    }


    /**
     *
     * @return a URL object that we can use in our getJsonSchematicToString() method to get config.json data
     * @throws MalformedURLException no legal protocol could be found or the string could not be parsed.
     */
    public URL getJsonSchematicUrl() throws MalformedURLException {
        return new URL(JSON_SCHEMATICS_URL);
    }

    /**
     * Load JSON data from config file into map
     */
    private void loadMaps(){
        TypeReference<Map<String, Block>> typeReference = new TypeReference<Map<String, Block>>(){};
        try {
            Map<String, Block> blocks = OBJECT_MAPPER.readValue(this.configFile.getFile(), typeReference);
            this.manager.setBlocks(blocks);
        } catch (IOException e) {
            Bukkit.getLogger().log(Level.SEVERE, "Jackson could not parse data into Map<K,V>");
           deleteme(e.getMessage());
        }
    }

    void deleteme(String msg){
        Bukkit.getOnlinePlayers().stream().forEach(p -> p.sendMessage(msg));
    }

}
