package modernmarkings.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.IIcon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modernmarkings.ModernMarkings;
import modernmarkings.init.ModBlocks;
import modernmarkings.init.ModItems;

public class BlockBase extends Block {

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
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public String getUnlocalizedName() {
        return unlocalizedName;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        this.icon = register.registerIcon(ModernMarkings.MODID + ":" + textureName);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        return this.icon;
    }
}
