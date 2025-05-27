package modernmarkings.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import modernmarkings.renderer.MarkingFloorRenderer;
import modernmarkings.renderer.MarkingWallRenderer;

public class ClientProxy extends CommonProxy {

    @Override
    public void initRenderers() {
        renderMarkingWallID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new MarkingWallRenderer());

        renderMarkingFloorID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new MarkingFloorRenderer());
    }
}
