package modernmarkings.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modernmarkings.ModernMarkings;
import modernmarkings.init.ModBlocks;
import modernmarkings.init.ModItems;
import modernmarkings.util.IHasModel;
import modernmarkings.util.Resource;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class MarkingFloor extends BlockBase implements IHasModel {
    public String unlocalizedName;
    private IIcon icon;

    public MarkingFloor(String name, String textureName) {
        super(name, textureName);
        setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.1f, 1.0f);
    }

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World worldIn, int x, int y, int z)
    {
        return AxisAlignedBB.getBoundingBox(0.0, 0.0, 0.0, 1.0, 0.1, 1.0);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World worldIn, int x, int y, int z)
    {
        return AxisAlignedBB.getBoundingBox(0,0,0,0,0,0);
    }
}
