package thesadpie.variousutils.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import thesadpie.variousutils.VariousUtils;
import  net.minecraft.registry.Registry;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import  net.minecraft.registry.Registries;
import thesadpie.variousutils.item.custom.TNTRemoteItem;

public class ModItems {

    public static final Item TNT_Remote = registerItem("tnt_remote",
            new TNTRemoteItem(new FabricItemSettings().maxCount(1)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(VariousUtils.MOD_ID, name), item);
    }

    public static void addItemsToItemGroups(){
        addToItemGroup(ItemGroups.FUNCTIONAL, TNT_Remote);
    }

    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems(){
        VariousUtils.LOGGER.debug("Registering items for " + VariousUtils.MOD_ID);

        addItemsToItemGroups();
    }
}
