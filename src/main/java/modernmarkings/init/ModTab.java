package modernmarkings.init;

import modernmarkings.util.Resource;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModTab extends CreativeTabs {

    /**
     * Create new Creative Tabs here!
     */

    /**
     * creating the Name of a new Creative Tab
     */
    public ModTab(String name) {
        super(Resource.MOD_ID + "." + name);
    }

    @Override
    public Item getTabIconItem() {
        return new ItemStack(ModItems.CHALK).getItem();
    }
}
