package modernmarkings.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import modernmarkings.renderer.MarkingFloorRenderer;
import modernmarkings.renderer.MarkingWallRenderer;

public class ClientProxy extends CommonProxy {

    @Override
    public void initRenderers() {
        // Get the next available render ID.
        renderMarkingWallID = RenderingRegistry.getNextAvailableRenderId();
        // Register the custom renderer.
        RenderingRegistry.registerBlockHandler(new MarkingWallRenderer());

        // Get the next available render ID.
        renderMarkingFloorID = RenderingRegistry.getNextAvailableRenderId();
        // Register the custom renderer.
        RenderingRegistry.registerBlockHandler(new MarkingFloorRenderer());
    }
}
