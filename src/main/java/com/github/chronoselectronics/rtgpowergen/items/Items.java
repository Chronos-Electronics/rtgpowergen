package com.github.chronoselectronics.rtgpowergen.items;

import com.github.chronoselectronics.rtgpowergen.Utils.Registerable;
import com.github.chronoselectronics.rtgpowergen.items.items.BallZ;


public class Items implements Registerable {
    static public Items INSTANCE = new Items();

    static public BallZ BALLZ = new BallZ();
    static public BaseItem SCREWDRIVER = new BaseItem().regName("screwdriver");
    static public BaseItem COIN = new BaseItem().regName("coin");

    @Override
    public void register() {
        preRegister();

        BALLZ.register();
        SCREWDRIVER.register();
        COIN.register();
    }

    private void preRegister(){
        BALLZ.regName("ballz");
    }
}
