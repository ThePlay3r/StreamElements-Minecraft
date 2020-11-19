package me.pljr.streamelementsminecraft.config;

import me.pljr.pljrapi.managers.ConfigManager;
import me.pljr.streamelementsminecraft.enums.StreamEventType;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemsCfg {
    public static HashMap<StreamEventType, List<ItemStack>> items;

    public static void load(ConfigManager config){
        items = new HashMap<>();
        for (StreamEventType type : StreamEventType.values()){
            List<ItemStack> list = new ArrayList<>();
            ConfigurationSection itemsCs = config.getConfigurationSection("items."+type.toString());
            if (itemsCs != null){
                for (String item : itemsCs.getKeys(false)){
                    list.add(config.getSimpleItemStack("items."+type.toString()+"."+item));
                }
            }
            items.put(type, list);
        }
    }
}
