package modernmarkings.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modernmarkings.ModernMarkings;
import modernmarkings.init.ModBlocks;
import modernmarkings.init.ModItems;
import modernmarkings.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.IIcon;

public class BlockBase extends Block implements IHasModel {

    public String unlocalizedName;

    private final String textureName;
    private IIcon icon;


    protected BlockBase(String name, String textureName) {
        super(Material.carpet);
        this.unlocalizedName = name;
        this.textureName = textureName;

        setCreativeTab(ModernMarkings.CREATIVE_TAB);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this));

    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }


    @Override
    public void registerModels() {
        ModernMarkings.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

    @Override
    public String getUnlocalizedName() {
        return unlocalizedName;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        // Replace the string with your resource string, e.g. "modid:my_texture"
        this.icon = register.registerIcon(ModernMarkings.MODID + ":"+textureName);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        return this.icon;
    }
}
