package com.github.chronoselectronics.rtgpowergen.blocks;

import com.github.chronoselectronics.rtgpowergen.Utils.Registerable;
import com.github.chronoselectronics.rtgpowergen.blocks.demoncore.Demoncore;
import com.github.chronoselectronics.rtgpowergen.blocks.stickmachine.SecretMachine;

public class Blocks implements Registerable {
    static public Blocks INSTANCE = new Blocks();

    static public Demoncore DEMON_CORE = new Demoncore();

    @Override
    public void register() {
        preRegister();

        SecretMachine.INSTANCE.register();
        DEMON_CORE.register();
    }

    protected void preRegister() {
        DEMON_CORE.regName("demoncore");
    }
}
