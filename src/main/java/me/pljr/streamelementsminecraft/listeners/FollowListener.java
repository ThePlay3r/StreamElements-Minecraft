package me.pljr.streamelementsminecraft.listeners;

import me.limeglass.streamelements.api.annotations.EventListener;
import me.limeglass.streamelements.api.events.FollowEvent;
import me.pljr.streamelementsminecraft.config.SettingsCfg;
import me.pljr.streamelementsminecraft.enums.StreamEventType;
import me.pljr.streamelementsminecraft.objects.StreamEvent;

public class FollowListener extends StreamEvent {

    public FollowListener(){
        super(SettingsCfg.followEnabled, StreamEventType.follow);
    }

    @EventListener
    public void onFollow(FollowEvent event){
        System.out.println("[Stream] Follow from " + event.getName());
        run(event.getName(), "");
    }
}
