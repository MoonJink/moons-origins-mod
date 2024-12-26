package net.moonjink.moonsoriginsmod.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BottleItem;
import net.minecraft.world.item.HoneyBottleItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.item.custom.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Moonsoriginsmod.MOD_ID);

    public static final RegistryObject<Item> LICH_BORNE_IRON = ITEMS.register("lich_borne_iron",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SHADOW_CRYSTAL = ITEMS.register("shadow_crystal",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SOUL_CRYSTAL = ITEMS.register("soul_crystal",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> ARCANE_CRYSTAL = ITEMS.register("arcane_crystal",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> WATER_CRYSTAL = ITEMS.register("water_crystal",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> EMPTY_BLOOD_VIAL = ITEMS.register("empty_blood_vial",
            () -> new Item(new Item.Properties().stacksTo(8)));

    public static final RegistryObject<Item> LESSER_BLOOD_VIAL = ITEMS.register("lesser_blood_vial",
            () -> new BloodVialItem(new Item.Properties().stacksTo(8)
                    .food((new FoodProperties.Builder()).nutrition(0).saturationMod(0).build())));

    public static final RegistryObject<Item> GREATER_BLOOD_VIAL = ITEMS.register("greater_blood_vial",
            () -> new BloodVialItem(new Item.Properties().stacksTo(4)
                    .food((new FoodProperties.Builder()).nutrition(0).saturationMod(0).build())));




    public static final RegistryObject<Item> LICH_GAUNTLET = ITEMS.register("lich_gauntlet",
            () -> new LichGauntletFullItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> LICH_GAUNTLET_EMPTY = ITEMS.register("lich_gauntlet_empty",
            () -> new LichGauntletEmptyItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> LICH_GAUNTLET_SHADOW = ITEMS.register("lich_gauntlet_shadow",
            () -> new LichGauntletShadowItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> LICH_GAUNTLET_SOUL = ITEMS.register("lich_gauntlet_soul",
            () -> new LichGauntletSoulItem(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
