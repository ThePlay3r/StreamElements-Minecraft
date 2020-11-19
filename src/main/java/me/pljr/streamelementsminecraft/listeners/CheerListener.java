package me.pljr.streamelementsminecraft.listeners;

import me.limeglass.streamelements.api.annotations.EventListener;
import me.limeglass.streamelements.api.events.CheerEvent;
import me.pljr.streamelementsminecraft.config.SettingsCfg;
import me.pljr.streamelementsminecraft.enums.StreamEventType;
import me.pljr.streamelementsminecraft.objects.StreamEvent;

public class CheerListener extends StreamEvent {

    public CheerListener(){
        super(SettingsCfg.cheerEnabled, StreamEventType.cheer);
    }

    @EventListener
    public void onCheer(CheerEvent event){
        System.out.println("[Stream] Cheer from " + event.getName() + " of " + event.getAmount() + " bits.");
        run(event.getName(), event.getAmount().floatValue()+"");
    }
}
