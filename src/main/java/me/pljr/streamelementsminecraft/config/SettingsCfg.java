package me.pljr.streamelementsminecraft.config;

import me.pljr.pljrapi.managers.ConfigManager;

public class SettingsCfg {
    public static boolean cheerEnabled;
    public static boolean followEnabled;
    public static boolean hostEnabled;
    public static boolean subscriberEnabled;
    public static boolean tipEnabled;
    public static boolean randomItems;

    public static void load(ConfigManager config){
        cheerEnabled = config.getBoolean("settings.cheer-enabled");
        followEnabled = config.getBoolean("settings.follow-enabled");
        hostEnabled = config.getBoolean("settings.host-enabled");
        subscriberEnabled = config.getBoolean("settings.subscriber-enabled");
        tipEnabled = config.getBoolean("settings.tip-enabled");
        randomItems = config.getBoolean("settings.random-items");
    }
}
