
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.rit.pojiy.init;

import net.rit.pojiy.item.XingYunNiuDanItem;
import net.rit.pojiy.PojiyMod;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

public class PojiyModItems {
	public static Item XING_YUN_NIU_DAN;

	public static void load() {
		XING_YUN_NIU_DAN = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PojiyMod.MODID, "xing_yun_niu_dan"), new XingYunNiuDanItem());
	}
}
