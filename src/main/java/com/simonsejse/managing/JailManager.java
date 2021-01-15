package com.simonsejse.managing;

import java.util.HashMap;
import java.util.Map;

public class JailManager {

    /* Properties */
    /**
     * @Key string of the name e.g. 'A' | 'B'
     * @Value Block object containing all data of the block
     * @Usage blocks.get('A') returns Block object
     */
    private Map<String, Block> blocks = new HashMap<>();

    /**
     *
     * @param blocks new map data
     */
    public void setBlocks(Map<String, Block> blocks){
        this.blocks = blocks;
    }

    /**
     *
     * @return map containing block data
     */
    public Map<String,Block> getBlocks(){
        return this.blocks;
    }


}
