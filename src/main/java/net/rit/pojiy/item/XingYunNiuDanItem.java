
package net.rit.pojiy.item;

import net.rit.pojiy.procedures.XingYunNiuDanDangYouJianDianJiKongQiShiShiTiDeWeiZhiProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public class XingYunNiuDanItem extends Item {
	public XingYunNiuDanItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS).register(content -> content.accept(this));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 32;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		XingYunNiuDanDangYouJianDianJiKongQiShiShiTiDeWeiZhiProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", world).put("x", x).put("y", y).put("z", z).put("entity", entity).build());
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		InteractionResult retval = super.useOn(context);
		XingYunNiuDanDangYouJianDianJiKongQiShiShiTiDeWeiZhiProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", context.getLevel()).put("x", context.getClickedPos().getX())
				.put("y", context.getClickedPos().getY()).put("z", context.getClickedPos().getZ()).put("entity", context.getPlayer()).build());
		return retval;
	}
}
