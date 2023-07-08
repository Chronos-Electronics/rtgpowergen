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

    @Override
    public void register() {
        preRegister();

        BALLZ.register();
        SCREWDRIVER.register();
        COIN.register();

        RUMBLING_RECORD.register();
    }

    private void preRegister(){
        BALLZ.regName("ballz");
    }
}
