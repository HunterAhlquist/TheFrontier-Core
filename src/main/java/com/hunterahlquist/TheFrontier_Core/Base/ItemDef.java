package com.hunterahlquist.TheFrontier_Core.Base;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemDef {
	
	public static ItemStack defineChargedCreeperEgg() {
		ItemStack chargedCreeperEgg;
		chargedCreeperEgg = new ItemStack(Material.CREEPER_SPAWN_EGG, 1);
		chargedCreeperEgg.addUnsafeEnchantment(Enchantment.VANISHING_CURSE, 1);
		ItemMeta chargedCEMeta = chargedCreeperEgg.getItemMeta();
		List<String> loreText = Arrays.asList("The creeper egg shakes violently as if", "it's about to explode in your hand.");
		chargedCEMeta.setLore(loreText);
		chargedCEMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		chargedCEMeta.setDisplayName("Creeper Spawn Egg [Charged]");
		chargedCreeperEgg.setItemMeta(chargedCEMeta);
		
		return chargedCreeperEgg;
		
	}
}
