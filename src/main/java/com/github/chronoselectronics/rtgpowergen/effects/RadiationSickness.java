package com.github.chronoselectronics.rtgpowergen.effects;

import com.github.chronoselectronics.rtgpowergen.Rtgpowergen;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;

public class RadiationSickness extends Potion {

    public RadiationSickness() {
        super(false, 0xFF00FF); // Customize the color as desired
        setPotionName("potion.radiation_sickness");

        setIconIndex(0, 0); // Customize the icon index if needed

        setEffectiveness(0.25D); // Adjust the effectiveness value as needed
        setRegistryName(Rtgpowergen.MOD_ID, "radiation_sickness");
    }

    @Override
    public void performEffect(EntityLivingBase entity, int amplifier) {
        entity.attackEntityFrom(new DamageSource("radiation").setDamageBypassesArmor().setMagicDamage(), 1);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        // The effect is always active
        return true;
    }
}

