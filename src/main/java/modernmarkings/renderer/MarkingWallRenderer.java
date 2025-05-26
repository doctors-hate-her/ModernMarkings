package modernmarkings.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modernmarkings.ModernMarkings;

@SideOnly(Side.CLIENT)
public class MarkingWallRenderer implements ISimpleBlockRenderingHandler {

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
        // Bind the block texture map
        Minecraft.getMinecraft()
            .getTextureManager()
            .bindTexture(TextureMap.locationBlocksTexture);

        Tessellator tessellator = Tessellator.instance;

        // Begin drawing quads
        tessellator.startDrawingQuads();

        // Get the icon for a particular side (0 used here)
        IIcon icon = block.getIcon(0, metadata);

        // Grab the min/max U/V from the icon
        float uMin = icon.getMinU();
        float uMax = icon.getMaxU();
        float vMin = icon.getMinV();
        float vMax = icon.getMaxV();

        // Translate and rotate if necessary.
        // For a flat quad, we draw in the X-Y plane at Z=0.
        GL11.glPushMatrix();
        // Center the quad at the origin
        GL11.glTranslatef(-0.5F, -0.5F, 0);

        // Draw a quad from (0,0) to (1,1)
        tessellator.addVertexWithUV(0.0, 0.0, 0.0, uMin, vMax);
        tessellator.addVertexWithUV(1.0, 0.0, 0.0, uMax, vMax);
        tessellator.addVertexWithUV(1.0, 1.0, 0.0, uMax, vMin);
        tessellator.addVertexWithUV(0.0, 1.0, 0.0, uMin, vMin);

        tessellator.draw();
        GL11.glPopMatrix();
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
        RenderBlocks renderer) {
        int meta = world.getBlockMetadata(x, y, z);
        // Decide which side the block is attached to, then set appropriate bounds.
        // For example, if meta==2 (north) you want to render only on that face:

        switch (meta) {
            case 2: // north
                renderer.setRenderBounds(0.0, 0.0, 0.9999, 1.0, 1.0, 1.0);
                break;
            case 3: // south
                renderer.setRenderBounds(0.0, 0.0, 0.0, 1.0, 1.0, 0.0001);
                break;
            case 4: // west
                renderer.setRenderBounds(0.9999, 0.0, 0.0, 1.0, 1.0, 1.0);
                break;
            case 5: // east
                renderer.setRenderBounds(0.0, 0.0, 0.0, 0.0001, 1.0, 1.0);
                break;
            default:
                return false; // If metadata is unexpected, don’t render.
        }

        // Now, obtain the icon from the block using getIcon().
        // You can choose the face you want to render; typically, pick the face that's exposed.
        // For example:
        IIcon icon = block.getIcon(getRenderSide(meta), meta);

        // Tell the renderer to use this icon when rendering.
        renderer.overrideBlockTexture = icon;
        boolean rendered = renderer.renderStandardBlock(block, x, y, z);
        renderer.clearOverrideBlockTexture();
        return rendered;
    }

    /**
     * Returns the block face (side) that should be used for the texture.
     * For example, if the block is attached to a wall, you might want the
     * texture of the face that attaches to the wall.
     *
     * @param metadata the block metadata (which you set in onBlockPlaced)
     * @return a side index between 0 and 5
     */
    private int getRenderSide(int metadata) {
        // Here we assume metadata is the same as the side (2, 3, 4, or 5),
        // which you set when the block is placed.
        // You might choose to force a specific side; for example, if a wall sign
        // always draws its "front" face.
        // In this example, simply return metadata.
        return metadata;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        // Return the same render ID as you used in your block.
        return ModernMarkings.proxy.renderMarkingWallID;
    }
}
