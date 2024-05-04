package net.rit.pojiy.procedures;

import net.rit.pojiy.PojiyMod;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;

import java.util.Map;
import java.util.HashMap;

public class ClonProcedure {
	public ClonProcedure() {
		UseBlockCallback.EVENT.register((player, level, hand, hitResult) -> {
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("world", level);
			dependencies.put("entity", player);
			dependencies.put("x", hitResult.getBlockPos().getX());
			dependencies.put("y", hitResult.getBlockPos().getY());
			dependencies.put("z", hitResult.getBlockPos().getZ());
			dependencies.put("blockstate", level.getBlockState(hitResult.getBlockPos()));
			dependencies.put("direction", hitResult.getDirection());
			execute(dependencies);
			return InteractionResult.PASS;
		});
	}

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PojiyMod.LOGGER.warn("Failed to load dependency world for procedure Clon!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PojiyMod.LOGGER.warn("Failed to load dependency x for procedure Clon!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PojiyMod.LOGGER.warn("Failed to load dependency y for procedure Clon!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PojiyMod.LOGGER.warn("Failed to load dependency z for procedure Clon!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PojiyMod.LOGGER.warn("Failed to load dependency entity for procedure Clon!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEEPSLATE_DIAMOND_ORE && (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.POLISHED_GRANITE)) : false)
				&& (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.GRANITE_STAIRS)) : false)) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.DIAMOND));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}
