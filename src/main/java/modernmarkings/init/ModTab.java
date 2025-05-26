package modernmarkings.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import modernmarkings.util.Resource;

public class ModTab extends CreativeTabs {

    public ModTab(String name) {
        super(Resource.MOD_ID + "." + name);
    }

    @Override
    public Item getTabIconItem() {
        return new ItemStack(ModItems.CHALK).getItem();
    }
}
