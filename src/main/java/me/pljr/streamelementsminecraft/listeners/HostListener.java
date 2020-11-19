package me.pljr.streamelementsminecraft.listeners;

import me.limeglass.streamelements.api.annotations.EventListener;
import me.limeglass.streamelements.api.events.HostEvent;
import me.pljr.streamelementsminecraft.config.SettingsCfg;
import me.pljr.streamelementsminecraft.enums.StreamEventType;
import me.pljr.streamelementsminecraft.objects.StreamEvent;

public class HostListener extends StreamEvent {

    public HostListener(){
        super(SettingsCfg.hostEnabled, StreamEventType.host);
    }

    @EventListener
    public void onHost(HostEvent event){
        System.out.println("[Stream] Host from " + event.getName() + " with " + event.getViewerCount() + " viewers.");
        run(event.getName(), event.getViewerCount().floatValue()+"");
    }
}
