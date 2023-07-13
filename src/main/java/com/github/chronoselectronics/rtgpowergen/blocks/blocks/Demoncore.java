package com.github.chronoselectronics.rtgpowergen.blocks.blocks;

import com.github.chronoselectronics.rtgpowergen.blocks.BaseBlock;
import com.github.chronoselectronics.rtgpowergen.effects.PotionEffects;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Demoncore extends BaseBlock {

    public Demoncore() {
        super(Material.IRON);
        setHardness(5);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState p_180639_3_, EntityPlayer player, EnumHand p_180639_5_, EnumFacing p_180639_6_, float p_180639_7_, float p_180639_8_, float p_180639_9_) {
        ItemStack heldItem = player.getHeldItem(EnumHand.MAIN_HAND);
        if (heldItem != null && heldItem.getItem().getRegistryName().toString().equals("rtgpowergen:screwdriver")) {
            // Spawn blue particles
            int particleCount = 100; // Number of particles to spawn
            double particleXSpeed = 1.0; // X-axis speed of particles
            double particleYSpeed = 0.0; // Y-axis speed of particles
            double particleZSpeed = 1.0; // Z-axis speed of particles

            // Spawn particles
            for (int i = 0; i < particleCount; i++) {
                 world.spawnParticle(EnumParticleTypes.SPELL_MOB, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, particleXSpeed, particleYSpeed, particleZSpeed);
            }
            // Apply wither effect to the player
            player.addPotionEffect(new PotionEffect(PotionEffects.RADIATION_SICKNESS, 9999999, 10));
            return true;
        }
        return false;
    }
}
