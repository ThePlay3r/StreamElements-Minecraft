package me.pljr.streamelementsminecraft.listeners;

import me.limeglass.streamelements.api.annotations.EventListener;
import me.limeglass.streamelements.api.events.SubscriberEvent;
import me.pljr.streamelementsminecraft.config.SettingsCfg;
import me.pljr.streamelementsminecraft.enums.StreamEventType;
import me.pljr.streamelementsminecraft.objects.StreamEvent;

public class SubscriberListener extends StreamEvent {

    public SubscriberListener(){
        super(SettingsCfg.subscriberEnabled, StreamEventType.subscriber);
    }

    @EventListener
    public void onSubscribe(SubscriberEvent event){
        System.out.println("[Stream] Subscribe from " + event.getName());
        run(event.getName(), "");
    }
}
