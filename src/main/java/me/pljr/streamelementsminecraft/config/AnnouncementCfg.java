package me.pljr.streamelementsminecraft.config;

import me.pljr.pljrapi.managers.ConfigManager;
import me.pljr.pljrapi.objects.PLJRActionBar;
import me.pljr.pljrapi.objects.PLJRSound;
import me.pljr.pljrapi.objects.PLJRTitle;
import me.pljr.streamelementsminecraft.enums.StreamEventType;
import me.pljr.streamelementsminecraft.objects.Announcement;

import java.util.HashMap;
import java.util.List;

public class AnnouncementCfg {
    public static HashMap<StreamEventType, Announcement> announcements;

    public static void load(ConfigManager config){
        announcements = new HashMap<>();
        for (StreamEventType type : StreamEventType.values()){
            PLJRTitle title = config.getPLJRTitle("announcement."+type.toString()+".title");
            PLJRActionBar actionBar = config.getPLJRActionBar("announcement."+type.toString()+".action-bar");
            PLJRSound sound = config.getPLJRSound("announcement."+type.toString()+".sound");
            List<String> broadcast = config.getStringList("announcement."+type.toString()+".broadcast");
            announcements.put(type, new Announcement(title, actionBar, sound, broadcast));
        }
    }
}
