package modernmarkings.proxy;

import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy {

    public void registerItemRenderer(Item item, int meta, String id) {
        //ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }
}
