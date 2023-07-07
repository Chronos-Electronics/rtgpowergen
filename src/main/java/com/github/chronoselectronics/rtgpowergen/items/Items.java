package com.github.chronoselectronics.rtgpowergen.items;

import com.github.chronoselectronics.rtgpowergen.Utils.Registerable;


public class Items implements Registerable {
    static public Items INSTANCE = new Items();
    static private BaseItem MEINARSCH = new BaseItem().regName("meinarsch");

    @Override
    public void register() {
        MEINARSCH.register();
    }
}
