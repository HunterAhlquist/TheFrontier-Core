package com.hunterahlquist.TheFrontier_Core.CustomEnchantments;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

import com.hunterahlquist.TheFrontier_Core.Base.Main;

public class SmeltingE extends Enchantment {
	public SmeltingE() {
		super(new NamespacedKey(Main.getPlugin(Main.class), "SMITHING"));
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Smelting";
	}

	@Override
	public int getMaxLevel() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getStartLevel() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		// TODO Auto-generated method stub
		return EnchantmentTarget.TOOL;
	}

	@Override
	public boolean isTreasure() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCursed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean conflictsWith(Enchantment other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canEnchantItem(ItemStack item) {
		// TODO Auto-generated method stub
		return true;
	}
}
