package net.moonjink.moonsoriginsmod.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> EMPTY_PILL_BOTTLE = ITEMS.register("empty_pill_bottle",
            () -> new Item(new Item.Properties().stacksTo(12)));



    public static final RegistryObject<Item> LESSER_BLOOD_VIAL = ITEMS.register("lesser_blood_vial",
            () -> new BloodVialItem(new Item.Properties().stacksTo(8)
                    .food((new FoodProperties.Builder()).nutrition(0).saturationMod(0).build())));

    public static final RegistryObject<Item> GREATER_BLOOD_VIAL = ITEMS.register("greater_blood_vial",
            () -> new BloodVialItem(new Item.Properties().stacksTo(4)
                    .food((new FoodProperties.Builder()).nutrition(0).saturationMod(0).build())));



    public static final RegistryObject<Item> ANTIPSYCHOTICS = ITEMS.register("antipsychotics",
            () -> new AntipsychoticItem(new Item.Properties().stacksTo(12)
                    .food((new FoodProperties.Builder()).nutrition(0).saturationMod(0).build())));;

                    public static final RegistryObject<Item> MAKESHIFT_ANTIPSYCHOTICS = ITEMS.register("makeshift_antipsychotics",
            () -> new MakeshiftAntipsychoticItem(new Item.Properties().stacksTo(6)
                    .food((new FoodProperties.Builder()).nutrition(2).saturationMod(0).build())));;

    public static final RegistryObject<Item> ANTIDEPRESSANTS = ITEMS.register("antidepressants",
            () -> new AntiDepressantItem(new Item.Properties().stacksTo(12)
                    .food((new FoodProperties.Builder()).nutrition(0).saturationMod(0).build())));;

    public static final RegistryObject<Item> LITHOBID = ITEMS.register("lithobid",
            () -> new LithobidItem(new Item.Properties().stacksTo(12)
                    .food((new FoodProperties.Builder()).nutrition(0).saturationMod(0).build())));;



    public static final RegistryObject<Item> VAMPIRE_DAGGER = ITEMS.register("vampire_dagger",
            () -> new SwordItem(Tiers.IRON, 3, -2.4F, new Item.Properties().stacksTo(1)));



    public static final RegistryObject<Item> LICH_GAUNTLET = ITEMS.register("lich_gauntlet",
            () -> new LichGauntletFullItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> LICH_GAUNTLET_EMPTY = ITEMS.register("lich_gauntlet_empty",
            () -> new LichGauntletEmptyItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> LICH_GAUNTLET_SHADOW = ITEMS.register("lich_gauntlet_shadow",
            () -> new LichGauntletShadowItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> LICH_GAUNTLET_SOUL = ITEMS.register("lich_gauntlet_soul",
            () -> new LichGauntletSoulItem(new Item.Properties().stacksTo(1)));



    public static final RegistryObject<Item> MENTALLY_ILL_ICON = ITEMS.register("mentally_ill_icon",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> BIPOLAR_ICON = ITEMS.register("bipolar_icon",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> COTARDS_ICON = ITEMS.register("cotards_icon",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> DID_ICON = ITEMS.register("did_icon",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SCHIZOPHRENIA_ICON = ITEMS.register("schizophrenia_icon",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
