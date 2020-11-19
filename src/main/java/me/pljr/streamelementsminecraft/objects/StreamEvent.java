package me.pljr.streamelementsminecraft.objects;

import me.pljr.pljrapi.XMaterial;
import me.pljr.pljrapi.builders.ItemBuilder;
import me.pljr.pljrapi.managers.ActionBarManager;
import me.pljr.pljrapi.managers.TitleManager;
import me.pljr.pljrapi.objects.PLJRActionBar;
import me.pljr.pljrapi.objects.PLJRTitle;
import me.pljr.pljrapi.utils.ChatUtil;
import me.pljr.pljrapi.utils.PlayerUtil;
import me.pljr.streamelementsminecraft.StreamElementsMinecraft;
import me.pljr.streamelementsminecraft.config.AnnouncementCfg;
import me.pljr.streamelementsminecraft.config.ItemsCfg;
import me.pljr.streamelementsminecraft.config.SettingsCfg;
import me.pljr.streamelementsminecraft.enums.StreamEventType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class StreamEvent {
    private final boolean enabled;
    private final StreamEventType type;

    public StreamEvent(boolean enabled, StreamEventType type){
        this.enabled = enabled;
        this.type = type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void run(String name, String amount){
        if (isEnabled()){
            Bukkit.getScheduler().runTaskAsynchronously(StreamElementsMinecraft.getInstance(), ()->{
                Announcement announcement = AnnouncementCfg.announcements.get(type);
                PLJRTitle title = new PLJRTitle(
                        announcement.getTitle().getTitle().replace("%user", name).replace("%amount", amount),
                        announcement.getTitle().getSubtitle().replace("%user", name).replace("%amount", amount),
                        announcement.getTitle().getIn(), announcement.getTitle().getStay(), announcement.getTitle().getOut()
                );
                PLJRActionBar actionBar = new PLJRActionBar(
                        announcement.getActionBar().getMessage().replace("%user", name).replace("%amount", amount),
                        announcement.getActionBar().getDuration()
                );
                List<String> messages = new ArrayList<>();
                for (String line : announcement.getBroadcast()){
                    messages.add(line.replace("%user", name).replace("%amount", amount));
                }
                TitleManager.broadcast(title);
                ActionBarManager.broadcast(actionBar);
                ChatUtil.broadcast(messages, "", false);
                List<ItemStack> items = ItemsCfg.items.get(type);
                for (Player player : Bukkit.getOnlinePlayers()){
                    Random random = new Random();
                    if (SettingsCfg.randomItems){
                        PlayerUtil.give(player, items.get(random.nextInt(items.size())));
                    }else{
                        List<XMaterial> materials = Arrays.asList(XMaterial.values().clone());
                        materials.remove(XMaterial.BEDROCK);
                        materials.remove(XMaterial.BARRIER);
                        materials.remove(XMaterial.AIR);
                        ItemStack itemStack = new ItemBuilder(materials.get(random.nextInt(materials.size()))).create();
                        PlayerUtil.give(player, itemStack);
                    }
                    player.playSound(player.getLocation(),
                            announcement.getSound().getType(),
                            announcement.getSound().getVolume(),
                            announcement.getSound().getPitch());
                }
            });
        }
    }
}
