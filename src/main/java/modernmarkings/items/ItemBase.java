package modernmarkings.items;

import modernmarkings.ModernMarkings;
import modernmarkings.ModernMarkings;
import modernmarkings.init.ModItems;
import modernmarkings.util.Resource;
import modernmarkings.util.IHasModel;
import net.minecraft.item.Item;

import static modernmarkings.ModernMarkings.CREATIVE_TAB;

public class ItemBase extends Item implements IHasModel {

    /**
     * Creating the Base of a new Mod Item
     * @param name                 Name for the Item
     */
    public ItemBase(String name) {
        /* Setting the Name of the Block / Item */
        //setTranslationKey(name);
        /* Setting the Registry Name of the Block / Item */
        //setRegistryName(Resource.MOD_ID, name);
        /* The Tab where the Item will be placed */
        setCreativeTab(CREATIVE_TAB);

        ModItems.ITEMS.add(this);
    }

    /**
     * Registering the Model of the Mod Items
     */
    @Override
    public void registerModels() {
        ModernMarkings.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
