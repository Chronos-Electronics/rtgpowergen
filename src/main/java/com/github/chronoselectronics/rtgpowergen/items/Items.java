package com.github.chronoselectronics.rtgpowergen.items;

import com.github.chronoselectronics.rtgpowergen.Utils.Registerable;
import com.github.chronoselectronics.rtgpowergen.Utils.Sounds;
import com.github.chronoselectronics.rtgpowergen.items.items.BallZ;
import com.github.chronoselectronics.rtgpowergen.items.items.Coin;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;


public class Items implements Registerable {
    static public BallZ BALLZ = new BallZ();
    static public final BaseItem SCREWDRIVER = new BaseItem().regName("screwdriver");
    static public final Coin COIN = new Coin("coin", Sounds.SOVIET_BACK);
    static public final BaseItem GLASS = new BaseItem().regName("glassofsus");


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
    static public final MusicDisc ZELDAA = new MusicDisc("zeldaa", Sounds.ZELDAA);
    static public final MusicDisc SPOODERMAN = new MusicDisc("spooderman", Sounds.SPOODERMAN);
    static public final MusicDisc BONNIE = new MusicDisc("bonnie", Sounds.BONNIE);
    static public final MusicDisc BLACK = new MusicDisc("black", Sounds.BLACK);
    static public final MusicDisc WINDMILL = new MusicDisc("windmill", Sounds.WINDMILL);
    static public final MusicDisc INFINITE = new MusicDisc("infinite", Sounds.INFINITE);
    static public final MusicDisc UNDEFEATABLE = new MusicDisc("undefeatable", Sounds.UNDEFEATABLE);
    static public final MusicDisc SEA = new MusicDisc("sea", Sounds.SEA);
    static public final MusicDisc DRAGONISLAND = new MusicDisc("dragonisland", Sounds.DRAGONISLAND);
    static public final MusicDisc COLGERA = new MusicDisc("colgera", Sounds.COLGERA);
    static public final MusicDisc STORM = new MusicDisc("storm", Sounds.STORM);
    static public final MusicDisc DEMO = new MusicDisc("demo", Sounds.DEMO);
    static public final MusicDisc FAIRY = new MusicDisc("fairy", Sounds.FAIRY);
    static public final MusicDisc CANON = new MusicDisc("canon", Sounds.CANON);
    static public final MusicDisc JUJUTSU = new MusicDisc("jujutsu", Sounds.JUJUTSU);
    static public final MusicDisc DREAMING = new MusicDisc("dreaming", Sounds.DREAMING);

    //AOT OPs
    static public final MusicDisc GUREN = new MusicDisc("guren", Sounds.GUREN);
    static public final MusicDisc JIYUU = new MusicDisc("jiyuu", Sounds.JIYUU);
    static public final MusicDisc SASAGEYO = new MusicDisc("sasageyo", Sounds.SASAGEYO);
    static public final MusicDisc SWAN = new MusicDisc("swan", Sounds.SWAN);
    static public final MusicDisc MIRKI = new MusicDisc("mirki", Sounds.MIRKI);
    static public final MusicDisc SENSOU = new MusicDisc("sensou", Sounds.SENSOU);

    //AOT EDs
    static public final MusicDisc AKUMA = new MusicDisc("akuma", Sounds.AKUMA);

    static public final MusicDisc SHOCK = new MusicDisc("shock", Sounds.SHOCK);
    // LEAVE THAT HERE {AUTOMATION MARK 1}
    @Override
    public void register() {
        preRegister();

        BALLZ.register();
        SCREWDRIVER.register();
        COIN.register();
        GLASS.register();


        RECORD_BASE.register();

        RUMBLING_RECORD.register();
        JADEPLUME_RECORD.register();
        MEGALOVANIA_RECORD.register();
        WMID_RECORD.register();
        KICK_BACK_RECORD.register();
        ZELDAA.register();
        SPOODERMAN.register();
        BONNIE.register();
        BLACK.register();
        WINDMILL.register();


        INFINITE.register();
        UNDEFEATABLE.register();
        SEA.register();
        DRAGONISLAND.register();
        COLGERA.register();
        STORM.register();
        DEMO.register();
        FAIRY.register();
        CANON.register();
        JUJUTSU.register();
        DREAMING.register();

        //AOT OPs
        GUREN.register();
        JIYUU.register();
        SASAGEYO.register();
        SWAN.register();
        MIRKI.register();
        SENSOU.register();

        //AOT EDs
        AKUMA.register();
        SHOCK.register();
        // LEAVE THAT HERE {AUTOMATION MARK 2}
    }

    private void preRegister(){
        BALLZ.regName("ballz");
        RECORD_BASE.setMaxStackSize(1);
    }
}
