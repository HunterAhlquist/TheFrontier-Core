package com.hunterahlquist.TheFrontier_Core.Base;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;


public class Crafting {
	
	public static ShapedRecipe chargedCreeperEggRecipe() {
		ItemStack chargedCreeperEgg = ItemDef.defineChargedCreeperEgg();
		chargedCreeperEgg.setAmount(4);
		
		NamespacedKey chargedCEKey = new NamespacedKey(Main.getPlugin(Main.class), "CHARGED_SPAWN_CREEPER_EGG");
		ShapedRecipe craftChargedCE = new ShapedRecipe(chargedCEKey, chargedCreeperEgg);
		craftChargedCE.shape("EEE","EEE","EEE");
		craftChargedCE.setIngredient('E', Material.CREEPER_SPAWN_EGG);
		
		return craftChargedCE;
	}
	
	public static ShapedRecipe enchGoldAppleRecipe() {
		ItemStack enchGoldApple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1);
		ItemMeta itemMeta = enchGoldApple.getItemMeta();
		itemMeta.setDisplayName("Enchanted Golden Apple");
		enchGoldApple.setItemMeta(itemMeta);
		
		NamespacedKey enchGoldAppleKey = new NamespacedKey(Main.getPlugin(Main.class), "ENCHANTED_GOLDEN_APPLE");
		ShapedRecipe craftEnchGoldApple = new ShapedRecipe(enchGoldAppleKey, enchGoldApple);
		craftEnchGoldApple.shape("BBB","BAB","BBB");
		craftEnchGoldApple.setIngredient('A', Material.GOLDEN_APPLE);
		craftEnchGoldApple.setIngredient('B', Material.GOLD_BLOCK);
		
		return craftEnchGoldApple;
	}
	
}
