package modernmarkings.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modernmarkings.ModernMarkings;
import modernmarkings.init.ModBlocks;
import modernmarkings.init.ModItems;
import modernmarkings.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;


public class MarkingWall extends Block implements IHasModel {
    public MarkingWall(String name) {
        super(Material.carpet);

        //setTranslationKey(name);
        //setRegistryName(Resource.MOD_ID, name);
        //setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));

        setCreativeTab(ModernMarkings.CREATIVE_TAB);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this));
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
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World worldIn, int x, int y, int z)
    {
        return AxisAlignedBB.getBoundingBox(0,0,0,0,0,0);
    }


    @Override
    public void registerModels() {
        ModernMarkings.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
