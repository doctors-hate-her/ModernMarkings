package modernmarkings.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;


public class MarkingWall extends BlockBase {

    public MarkingWall(String name, String textureName) {
        super(name, textureName);
    }

    private static final AxisAlignedBB BOUNDING_BOX_S = AxisAlignedBB.getBoundingBox(0.0, 0.0, 0.0, 1.0, 1.0, 0.1);
    private static final AxisAlignedBB BOUNDING_BOX_W = AxisAlignedBB.getBoundingBox(0.9, 0.0, 0.0, 1.0, 1.0, 1.0);
    private static final AxisAlignedBB BOUNDING_BOX_N = AxisAlignedBB.getBoundingBox(0.0, 0.0, 0.9, 1.0, 1.0, 1.0);
    private static final AxisAlignedBB BOUNDING_BOX_E = AxisAlignedBB.getBoundingBox(0.0, 0.0, 0.0, 0.1, 1.0, 1.0);

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World worldIn, int x, int y, int z)
    {
        int metadata = worldIn.getBlockMetadata(x, y, z);
        if(metadata > 4) return BOUNDING_BOX_N;

        EnumFacing direction = EnumFacing.values()[metadata];
        switch (direction) {
            case NORTH: return BOUNDING_BOX_N;
            case SOUTH: return BOUNDING_BOX_S;
            case EAST: return BOUNDING_BOX_E;
            case WEST: return BOUNDING_BOX_W;
            default: return BOUNDING_BOX_N; // Fallback
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World worldIn, int x, int y, int z) {
        return AxisAlignedBB.getBoundingBox(0, 0, 0, 0, 0, 0);
    }
}
