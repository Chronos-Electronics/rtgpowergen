package com.github.chronoselectronics.rtgpowergen.blocks;

import com.github.chronoselectronics.rtgpowergen.Utils.Registerable;
import com.github.chronoselectronics.rtgpowergen.blocks.blocks.DAW;
import com.github.chronoselectronics.rtgpowergen.blocks.blocks.Demoncore;
import com.github.chronoselectronics.rtgpowergen.blocks.blocks.Rtgpowergenerator;
import com.github.chronoselectronics.rtgpowergen.blocks.blocks.SecretMachine;

public class Blocks implements Registerable {
    static public Blocks INSTANCE = new Blocks();

    static public Demoncore DEMON_CORE = new Demoncore();
    static public DAW DAW_BLOCK = new DAW();
    static public Rtgpowergenerator GENERATOR = new Rtgpowergenerator();

    @Override
    public void register() {
        preRegister();

        SecretMachine.INSTANCE.register();
        DEMON_CORE.register();
        DAW_BLOCK.register();
        GENERATOR.register();
    }

    protected void preRegister() {
        DEMON_CORE.regName("demoncore");
        DAW_BLOCK.regName("daw");
        GENERATOR.regName("rtgpowergenerator");
    }
}
