package net.moonjink.moonsoriginsmod.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.item.custom.AnimatedItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Moonsoriginsmod.MOD_ID);

    public static final RegistryObject<Item> LICH_COIN = ITEMS.register("lich_coin",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> LICH_BORNE_IRON = ITEMS.register("lich_borne_iron",
            () -> new Item(new Item.Properties()));



    public static final RegistryObject<Item> LICH_GAUNTLET = ITEMS.register("lich_gauntlet",
            () -> new AnimatedItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> LICH_GAUNTLET_EMPTY = ITEMS.register("lich_gauntlet_empty",
            () -> new AnimatedItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> LICH_GAUNTLET_FLAME = ITEMS.register("lich_gauntlet_flame",
            () -> new AnimatedItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> LICH_GAUNTLET_SOUL = ITEMS.register("lich_gauntlet_soul",
            () -> new AnimatedItem(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
