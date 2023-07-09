package com.github.chronoselectronics.rtgpowergen.items;

import com.github.chronoselectronics.rtgpowergen.Utils.Registerable;
import com.github.chronoselectronics.rtgpowergen.Utils.Sounds;
import com.github.chronoselectronics.rtgpowergen.items.items.BallZ;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;


public class Items implements Registerable {
    static public BallZ BALLZ = new BallZ();
    static public final BaseItem SCREWDRIVER = new BaseItem().regName("screwdriver");
    static public final BaseItem COIN = new BaseItem().regName("coin");
    static public final BaseItem GALSS = new BaseItem().regName("glassofsus");


    static public final BaseItem RECORD_BASE = new BaseItem(){
        public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
            super.addInformation(stack, worldIn, tooltip, flagIn);
            tooltip.add(new TextComponentTranslation("tooltip.record_base.line").getFormattedText());
        }
    }.regName("record_base");

    static public final MusicDisc RUMBLING_RECORD = new MusicDisc("rumbling", Sounds.RUMBLING);
    static public final MusicDisc JADEPLUME_RECORD = new MusicDisc("jadeplume", Sounds.JADEPLUME);
    static public final MusicDisc MEGALOVANIA_RECORD = new MusicDisc("megalovania", Sounds.MEGALOVANIA);
    static public final MusicDisc WMID_RECORD = new MusicDisc("wmid", Sounds.WMID);
    static public final MusicDisc KICK_BACK_RECORD = new MusicDisc("kick_back", Sounds.KICK_BACK);
    static public final MusicDisc SOVIET_RECORD = new MusicDisc("soviet", Sounds.SOVIET_BACK);
    static public final MusicDisc ZELDAA = new MusicDisc("zeldaa", Sounds.ZELDAA);
    static public final MusicDisc SPOODERMAN = new MusicDisc("spooderman", Sounds.SPOODERMAN);
    static public final MusicDisc BONNIE = new MusicDisc("bonnie", Sounds.BONNIE);
    static public final MusicDisc BLACK = new MusicDisc("black", Sounds.BLACK);

    @Override
    public void register() {
        preRegister();

        BALLZ.register();
        SCREWDRIVER.register();
        COIN.register();


        RECORD_BASE.register();

        RUMBLING_RECORD.register();
        JADEPLUME_RECORD.register();
        MEGALOVANIA_RECORD.register();
        WMID_RECORD.register();
        KICK_BACK_RECORD.register();
        SOVIET_RECORD.register();
        ZELDAA.register();
        SPOODERMAN.register();
        BONNIE.register();
        BLACK.register();
    }

    private void preRegister(){
        BALLZ.regName("ballz");
        RECORD_BASE.setMaxStackSize(1);
    }
}
