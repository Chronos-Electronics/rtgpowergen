package com.github.chronoselectronics.rtgpowergen.items;

import com.github.chronoselectronics.rtgpowergen.Utils.Registerable;
import com.github.chronoselectronics.rtgpowergen.Utils.Sounds;
import com.github.chronoselectronics.rtgpowergen.items.items.BallZ;


public class Items implements Registerable {
    static public Items INSTANCE = new Items();

    static public BallZ BALLZ = new BallZ();
    static public final BaseItem SCREWDRIVER = new BaseItem().regName("screwdriver");
    static public final BaseItem COIN = new BaseItem().regName("coin");

    static public final MusicDisc RUMBLING_RECORD = new MusicDisc("rumbling", Sounds.RUMBLING);
    static public final MusicDisc JADEPLUME_RECORD = new MusicDisc("jadeplume", Sounds.JADEPLUME);
    static public final MusicDisc MEGALOVANIA_RECORD = new MusicDisc("megalovania", Sounds.MEGALOVANIA);
    static public final MusicDisc WMID_RECORD = new MusicDisc("wmid", Sounds.WMID);
    static public final MusicDisc KICK_BACK_RECORD = new MusicDisc("kick_back", Sounds.KICK_BACK);
    static public final MusicDisc SOVIET_RECORD = new MusicDisc("soviet", Sounds.SOVIET_BACK);

    @Override
    public void register() {
        preRegister();

        BALLZ.register();
        SCREWDRIVER.register();
        COIN.register();

        RUMBLING_RECORD.register();
        JADEPLUME_RECORD.register();
        MEGALOVANIA_RECORD.register();
        WMID_RECORD.register();
        KICK_BACK_RECORD.register();
        SOVIET_RECORD.register();
    }

    private void preRegister(){
        BALLZ.regName("ballz");
    }
}
