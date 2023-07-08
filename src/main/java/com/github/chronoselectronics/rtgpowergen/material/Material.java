package com.github.chronoselectronics.rtgpowergen.material;

import com.github.chronoselectronics.rtgpowergen.Rtgpowergen;
import com.github.chronoselectronics.rtgpowergen.Utils.Registerable;
import com.github.chronoselectronics.rtgpowergen.blocks.BaseBlock;
import com.github.chronoselectronics.rtgpowergen.items.BaseItem;
import com.github.chronoselectronics.rtgpowergen.material.materials.Plutonium;
import com.github.chronoselectronics.rtgpowergen.material.materials.Thulium;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public class Material implements Registerable {
    protected static List<Material> instanceList = new ArrayList<Material>() {{
        add(Plutonium.INSTANCE);
        add(Thulium.INSTANCE);
    }};
    public static Material INSTANCE = new Material();

    public BaseItem getItem() {
        return null;
    }

    public BaseBlock getBlock() {
        return null;
    }

    public BaseBlock getOre() {
        return null;
    }


    public static void registerInstances() {
        for (Material material : instanceList) {
            material.register();
        }
    }

    @Override
    public void register() {
        registerInstances();
    }

    protected void registerNonMaterialSpecificPostRegister() {
        GameRegistry.addShapelessRecipe(new ResourceLocation(Rtgpowergen.MOD_ID, "plutonium_itemFromBlock"),
                null,
                new ItemStack(getItem(), 9),
                Ingredient.fromItem(getBlock().getItemBlock()));

        Ingredient ingotIngredient = Ingredient.fromItems(getItem());
        GameRegistry.addShapedRecipe(new ResourceLocation(Rtgpowergen.MOD_ID, "plutonium_blockFromItem"),
                null,
                new ItemStack(getBlock()),
                "III",
                "III",
                "III",
                'I', ingotIngredient);

        GameRegistry.addSmelting(getOre(), new ItemStack(getItem()), 1);

    }
}
