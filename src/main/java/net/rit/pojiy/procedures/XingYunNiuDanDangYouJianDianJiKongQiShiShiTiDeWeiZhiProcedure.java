package net.rit.pojiy.procedures;

import net.rit.pojiy.init.PojiyModItems;
import net.rit.pojiy.PojiyMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Illusioner;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Map;

public class XingYunNiuDanDangYouJianDianJiKongQiShiShiTiDeWeiZhiProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PojiyMod.LOGGER.warn("Failed to load dependency world for procedure XingYunNiuDanDangYouJianDianJiKongQiShiShiTiDeWeiZhi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PojiyMod.LOGGER.warn("Failed to load dependency x for procedure XingYunNiuDanDangYouJianDianJiKongQiShiShiTiDeWeiZhi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PojiyMod.LOGGER.warn("Failed to load dependency y for procedure XingYunNiuDanDangYouJianDianJiKongQiShiShiTiDeWeiZhi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PojiyMod.LOGGER.warn("Failed to load dependency z for procedure XingYunNiuDanDangYouJianDianJiKongQiShiShiTiDeWeiZhi!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PojiyMod.LOGGER.warn("Failed to load dependency entity for procedure XingYunNiuDanDangYouJianDianJiKongQiShiShiTiDeWeiZhi!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(PojiyModItems.XING_YUN_NIU_DAN);
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
		if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"summon minecraft:creeper ~ ~1 ~ {powered:1b}");
		}
		if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"summon minecraft:skeleton ~ ~1 ~ {DeathLootTable:\"entities/skeleton\",ActiveEffects:[{Id:1,Amplifier:1,Duration:6000}],HandItems:[{id:\"minecraft:iron_sword\",Count:1b},{id:\"minecraft:netherite_scrap\",Count:1b}],HandDropChances:[0.05f,0.01f]}");
		}
		if (Mth.nextInt(RandomSource.create(), 1, 20) == 3) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new Illusioner(EntityType.ILLUSIONER, _level);
				entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if (Mth.nextInt(RandomSource.create(), 1, 10) == 4) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new EnderMan(EntityType.ENDERMAN, _level);
				entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if (Mth.nextInt(RandomSource.create(), 1, 20) == 5) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new Evoker(EntityType.EVOKER, _level);
				entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new Blaze(EntityType.BLAZE, _level);
				entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 1), z, new ItemStack(Items.DIAMOND));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}
