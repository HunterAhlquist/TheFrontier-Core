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
		chargedCreeperEgg.addUnsafeEnchantment(Enchantment.LUCK, 1);
		ItemMeta chargedCEMeta = chargedCreeperEgg.getItemMeta();
		List<String> loreText = Arrays.asList("Creates a charged creeper,", "be safe with it.");
		chargedCEMeta.setLore(loreText);
		chargedCEMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		chargedCEMeta.setDisplayName("Creeper Spawn Egg [Charged]");
		chargedCreeperEgg.setItemMeta(chargedCEMeta);
		
		return chargedCreeperEgg;
		
	}
	
	public static ItemStack defineBedTPItem() {
		ItemStack bedTP;
		bedTP = new ItemStack(Material.ENDER_EYE, 1);
		bedTP.addUnsafeEnchantment(Enchantment.LUCK, 1);
		ItemMeta bedTPMeta = bedTP.getItemMeta();
		List<String> loreText = Arrays.asList("Like an ender eye, but more tired.", "Will teleport to your bed to get some shut-eye.");
		bedTPMeta.setLore(loreText);
		bedTPMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		bedTPMeta.setDisplayName("Sleepy Eye");
		bedTP.setItemMeta(bedTPMeta);
		
		return bedTP;
	}
}
