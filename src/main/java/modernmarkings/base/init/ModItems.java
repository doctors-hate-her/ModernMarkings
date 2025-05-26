package modernmarkings.base.init;

import modernmarkings.base.items.ItemBase;
import modernmarkings.base.util.Resource;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    /**
 * Storing all Mod Items in an Array List
 */
public static final List<Item> ITEMS = new ArrayList<Item>();
    /**
     * function  to create new Items
     */


    public static final Item CHALK = new ItemBase("chalk");
    /** function to create new Food */
    // https://minecraft.gamepedia.com/Hunger
    // public static final Item FOOD_NAME = new FoodBase("food_name", 2, 3.5f, false);

    /** function to create new Food with Effects */
    // public static final Item FOOD_NAME = new FoodEffectBase("food_name", 2, 3.5f, false,
    //		new PotionEffect(MobEffects.HASTE, 60*20, 0, false, true));
}
