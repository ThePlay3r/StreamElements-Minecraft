package me.pljr.streamelementsminecraft.objects;

import me.pljr.pljrapi.objects.PLJRActionBar;
import me.pljr.pljrapi.objects.PLJRSound;
import me.pljr.pljrapi.objects.PLJRTitle;

import java.util.List;

public class Announcement {
    private final PLJRTitle title;
    private final PLJRActionBar actionBar;
    private final PLJRSound sound;
    private final List<String> broadcast;

    public Announcement(PLJRTitle title, PLJRActionBar actionBar, PLJRSound sound, List<String> broadcast) {
        this.title = title;
        this.actionBar = actionBar;
        this.sound = sound;
        this.broadcast = broadcast;
    }

    public PLJRTitle getTitle() {
        return title;
    }

    public PLJRActionBar getActionBar() {
        return actionBar;
    }

    public PLJRSound getSound() {
        return sound;
    }

    public List<String> getBroadcast() {
        return broadcast;
    }
}
