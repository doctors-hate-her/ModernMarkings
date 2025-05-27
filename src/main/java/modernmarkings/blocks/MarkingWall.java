package modernmarkings.blocks;

import static modernmarkings.init.ModBlocks.WALL_BLOCKS;

import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modernmarkings.ModernMarkings;

public class MarkingWall extends BlockBase {

    public MarkingWall(String name, String textureName) {
        super(name, textureName);
        WALL_BLOCKS.add(this);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    private static final AxisAlignedBB BOUNDING_BOX_S = AxisAlignedBB.getBoundingBox(0.0, 0.0, 0.0, 1.0, 1.0, 0.0001);
    private static final AxisAlignedBB BOUNDING_BOX_W = AxisAlignedBB.getBoundingBox(0.9999, 0.0, 0.0, 1.0, 1.0, 1.0);
    private static final AxisAlignedBB BOUNDING_BOX_N = AxisAlignedBB.getBoundingBox(0.0, 0.0, 0.9999, 1.0, 1.0, 1.0);
    private static final AxisAlignedBB BOUNDING_BOX_E = AxisAlignedBB.getBoundingBox(0.0, 0.0, 0.0, 0.0001, 1.0, 1.0);

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
        // Only allow placement on wall sides. If placed on top or bottom, default
        // to north (metadata 2) or you can adjust as needed.
        if (side == 0 || side == 1) {
            return 2;
        }
        // Save the chosen facing into metadata.
        return side;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        switch (meta) {
            case 2: // North face clicked; sign is attached to north wall.
                return AxisAlignedBB.getBoundingBox(
                    x + BOUNDING_BOX_N.minX,
                    y + BOUNDING_BOX_N.minY,
                    z + BOUNDING_BOX_N.minZ,
                    x + BOUNDING_BOX_N.maxX,
                    y + BOUNDING_BOX_N.maxY,
                    z + BOUNDING_BOX_N.maxZ);
            case 3: // South
                return AxisAlignedBB.getBoundingBox(
                    x + BOUNDING_BOX_S.minX,
                    y + BOUNDING_BOX_S.minY,
                    z + BOUNDING_BOX_S.minZ,
                    x + BOUNDING_BOX_S.maxX,
                    y + BOUNDING_BOX_S.maxY,
                    z + BOUNDING_BOX_S.maxZ);
            case 4: // West
                return AxisAlignedBB.getBoundingBox(
                    x + BOUNDING_BOX_W.minX,
                    y + BOUNDING_BOX_W.minY,
                    z + BOUNDING_BOX_W.minZ,
                    x + BOUNDING_BOX_W.maxX,
                    y + BOUNDING_BOX_W.maxY,
                    z + BOUNDING_BOX_W.maxZ);
            case 5: // East
                return AxisAlignedBB.getBoundingBox(
                    x + BOUNDING_BOX_E.minX,
                    y + BOUNDING_BOX_E.minY,
                    z + BOUNDING_BOX_E.minZ,
                    x + BOUNDING_BOX_E.maxX,
                    y + BOUNDING_BOX_E.maxY,
                    z + BOUNDING_BOX_E.maxZ);
            default:
                // Fallback if metadata is not as expected.
                return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1, z + 1);
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World worldIn, int x, int y, int z) {
        return AxisAlignedBB.getBoundingBox(0, 0, 0, 0, 0, 0);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderType() {
        // Return the custom render ID you registered in your client proxy.
        return ModernMarkings.proxy.renderMarkingWallID;
    }
}
