package modernmarkings.blocks;

import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modernmarkings.ModernMarkings;

public class MarkingFloor extends BlockBase {

    public MarkingFloor(String name, String textureName) {
        super(name, textureName);
        setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.0001f, 1.0f);
    }

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World worldIn, int x, int y, int z) {
        return AxisAlignedBB.getBoundingBox(0.0, 0.0, 0.0, 1.0, 0.0001, 1.0);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World worldIn, int x, int y, int z) {
        return AxisAlignedBB.getBoundingBox(0, 0, 0, 0, 0, 0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderType() {
        // Return the custom render ID you registered in your client proxy.
        return ModernMarkings.proxy.renderMarkingFloorID;
    }
}
