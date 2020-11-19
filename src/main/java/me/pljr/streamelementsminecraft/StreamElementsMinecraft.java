package me.pljr.streamelementsminecraft;

import me.limeglass.streamelements.api.StreamElements;
import me.limeglass.streamelements.api.StreamElementsBuilder;
import me.pljr.pljrapi.PLJRApi;
import me.pljr.pljrapi.managers.ConfigManager;
import me.pljr.streamelementsminecraft.config.AnnouncementCfg;
import me.pljr.streamelementsminecraft.config.ItemsCfg;
import me.pljr.streamelementsminecraft.config.SettingsCfg;
import me.pljr.streamelementsminecraft.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class StreamElementsMinecraft extends JavaPlugin {
    private static StreamElementsMinecraft instance;

    private ConfigManager configManager;
    private StreamElements streamElements;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        if (!setupPLJRApi()) return;
        setupConfig();
        setupStream();
    }

    private boolean setupPLJRApi(){
        PLJRApi api = (PLJRApi) Bukkit.getServer().getPluginManager().getPlugin("PLJRApi");
        if (api == null){
            Bukkit.getConsoleSender().sendMessage("§cStreamElements-Minecraft: PLJRApi not found, disabling plugin!");
            getServer().getPluginManager().disablePlugin(this);
            return false;
        }else{
            Bukkit.getConsoleSender().sendMessage("§aStreamElements-Minecraft: Hooked into PLJRApi!");
            return true;
        }
    }

    private void setupConfig(){
        saveDefaultConfig();
        configManager = new ConfigManager(getConfig(), "§cStreamElements-Minecraft:", "config.yml");
        AnnouncementCfg.load(configManager);
        ItemsCfg.load(configManager);
        SettingsCfg.load(configManager);
    }

    private void setupStream(){
        System.out.println("Setting up stream..");
        streamElements = new StreamElementsBuilder(
                configManager.getString("stream.account"),
                configManager.getString("stream.token"))
                .withConnectionTimeout(10000)
                .registerListeners(CheerListener.class)
                .registerListeners(FollowListener.class)
                .registerListeners(HostListener.class)
                .registerListeners(SubscriberListener.class)
                .registerListeners(TipListener.class).build();
    }

    public static StreamElementsMinecraft getInstance() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public StreamElements getStreamElements() {
        return streamElements;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
