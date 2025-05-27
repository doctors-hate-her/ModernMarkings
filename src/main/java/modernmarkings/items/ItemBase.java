package modernmarkings.items;

import static modernmarkings.ModernMarkings.CREATIVE_TAB;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modernmarkings.ModernMarkings;
import modernmarkings.init.ModItems;

public class ItemBase extends Item {

    private final String textureName;
    private IIcon icon;

    /**
     * Creating the Base of a new Mod Item
     *
     * @param name Name for the Item
     */
    public ItemBase(String name, String textureName) {
        this.textureName = textureName;
        setCreativeTab(CREATIVE_TAB);
        setUnlocalizedName(name);

        ModItems.ITEMS.add(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        this.icon = register.registerIcon(ModernMarkings.MODID + ":" + textureName);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        return this.icon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return this.icon;
    }

}
