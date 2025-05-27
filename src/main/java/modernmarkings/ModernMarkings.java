package modernmarkings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import modernmarkings.init.ModBlocks;
import modernmarkings.init.ModItems;
import modernmarkings.init.ModTab;
import modernmarkings.items.ModRecipes;
import modernmarkings.proxy.CommonProxy;
import modernmarkings.util.Resource;

@Mod(modid = Resource.MOD_ID, version = Resource.VERSION, name = Resource.NAME, acceptedMinecraftVersions = "[1.7.10]")
public class ModernMarkings {

    public static final String MODID = Resource.MOD_ID;
    public static final Logger LOG = LogManager.getLogger(MODID);
    public static final ModTab CREATIVE_TAB = new ModTab("modernmarkings");

    @SidedProxy(
        clientSide = Resource.MOD_ID + ".proxy.ClientProxy",
        serverSide = Resource.MOD_ID + ".proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        ModRecipes.registerRecipes();
        proxy.initRenderers();
    }

}
