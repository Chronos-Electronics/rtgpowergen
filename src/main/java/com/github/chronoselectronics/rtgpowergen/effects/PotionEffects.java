package com.github.chronoselectronics.rtgpowergen.effects;

import com.github.chronoselectronics.rtgpowergen.Utils.Registerable;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class PotionEffects implements Registerable {
    public static PotionEffects INSTANCE = new PotionEffects();

    static public final RadiationSickness RADIATION_SICKNESS = new RadiationSickness();
    @Override
    public void register() {
        ForgeRegistries.POTIONS.register(RADIATION_SICKNESS);
    }
}
