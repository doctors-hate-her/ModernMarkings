package modernmarkings.base.blocks;

import modernmarkings.base.Base;
import modernmarkings.base.init.ModBlocks;
import modernmarkings.base.init.ModItems;
import modernmarkings.base.util.IHasModel;
import modernmarkings.base.util.Resource;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class MarkingWall extends BlockHorizontal implements IHasModel {
    public MarkingWall(String name) {
        super(Material.CARPET);

        setTranslationKey(name);
        setRegistryName(Resource.MOD_ID, name);
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));

        setCreativeTab(Base.MOD_TAB);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
    private static final AxisAlignedBB BOUNDING_BOX_S = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.1);
    private static final AxisAlignedBB BOUNDING_BOX_W = new AxisAlignedBB(0.9, 0.0, 0.0, 1.0, 1.0, 1.0);
    private static final AxisAlignedBB BOUNDING_BOX_N = new AxisAlignedBB(0.0, 0.0, 0.9, 1.0, 1.0, 1.0);
    private static final AxisAlignedBB BOUNDING_BOX_E = new AxisAlignedBB(0.0, 0.0, 0.0, 0.1, 1.0, 1.0);



    @Override
    @Nullable
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        EnumFacing direction = state.getValue(FACING);
        switch (direction) {
            case NORTH: return BOUNDING_BOX_N;
            case SOUTH: return BOUNDING_BOX_S;
            case EAST: return BOUNDING_BOX_E;
            case WEST: return BOUNDING_BOX_W;
            default: return BOUNDING_BOX_N; // Fallback
        }
    }

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB; // Removes collision
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
        // No collision added
    }

    @Override
    public boolean isPassable(IBlockAccess world, BlockPos pos) {
        return true;
    }

    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }


    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { FACING });
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FACING, EnumFacing.byHorizontalIndex(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        EnumFacing facing = (EnumFacing) state.getValue(FACING);
        return facing.getHorizontalIndex();
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
                                            float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand).withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void registerModels() {
        Base.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
