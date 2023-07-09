package com.github.chronoselectronics.rtgpowergen.items.items;

import com.github.chronoselectronics.rtgpowergen.Rtgpowergen;
import com.github.chronoselectronics.rtgpowergen.items.MusicDisc;
import net.minecraft.util.SoundEvent;

public class Coin extends MusicDisc {
    public Coin(String name, SoundEvent soundEvent) {
        super(name, soundEvent);
    }

    @Override
    protected void reg(String name) {
        this.setRegistryName(name);
        setTranslationKey(Rtgpowergen.MOD_ID + "." + name);
    }
}
