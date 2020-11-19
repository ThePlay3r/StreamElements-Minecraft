package me.pljr.streamelementsminecraft.listeners;

import me.limeglass.streamelements.api.annotations.EventListener;
import me.limeglass.streamelements.api.events.TipEvent;
import me.pljr.streamelementsminecraft.config.SettingsCfg;
import me.pljr.streamelementsminecraft.enums.StreamEventType;
import me.pljr.streamelementsminecraft.objects.StreamEvent;

public class TipListener extends StreamEvent {

    public TipListener(){
        super(SettingsCfg.tipEnabled, StreamEventType.tip);
    }

    @EventListener
    public void onTip(TipEvent event){
        System.out.println("[Stream] Tip from " + event.getName() + " of " + event.getAmount() + event.getCurrency());
        run(event.getName(), event.getAmount().floatValue() + event.getCurrency());
    }
}
