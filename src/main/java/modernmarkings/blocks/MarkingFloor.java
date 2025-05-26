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
import net.minecraft.world.World;

public class MarkingFloor extends Block implements IHasModel {
    public MarkingFloor(String name) {
        super(Material.carpet);

        //setTranslationKey(name);
        //setRegistryName(Resource.MOD_ID, name);
        //setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));

        setCreativeTab(ModernMarkings.CREATIVE_TAB);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this));
    }

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World worldIn, int x, int y, int z)
    {
        return AxisAlignedBB.getBoundingBox(0.0, 0.0, 0.0, 1.0, 0.1, 1.0);
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
