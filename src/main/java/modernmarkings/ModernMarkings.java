package modernmarkings;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import modernmarkings.init.ModTab;
import modernmarkings.util.Resource;
import modernmarkings.proxy.CommonProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Resource.MOD_ID, version = Resource.VERSION, name = Resource.NAME, acceptedMinecraftVersions = "[1.7.10]")
public class ModernMarkings {

    public static final String MODID = Resource.MOD_ID;
    public static final Logger LOG = LogManager.getLogger(MODID);
    public static final ModTab CREATIVE_TAB = new ModTab("Modern Markings");

    @SidedProxy(clientSide = Resource.MOD_ID+".proxy.ClientProxy", serverSide = Resource.MOD_ID+".proxy.CommonProxy")
    public static CommonProxy proxy;

    /*
    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc., and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) { proxy.init(event);}

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
     */
}

