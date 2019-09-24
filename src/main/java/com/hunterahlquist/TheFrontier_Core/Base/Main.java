package com.hunterahlquist.TheFrontier_Core.Base;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.hunterahlquist.TheFrontier_Core.Definitions.Crafting;
import com.hunterahlquist.TheFrontier_Core.CustomEnchantments.SmeltingE;

import net.md_5.bungee.api.ChatColor;


public class Main extends JavaPlugin implements Listener {
	public static List<Enchantment> allCustomEnchantments = new ArrayList<Enchantment>();
	
	@Override
	public void onEnable() {
		//register custom enchantments into a list
		allCustomEnchantments.add(new SmeltingE());
		
		//startup plugin
		getServer().getPluginManager().registerEvents(new Events(), this);
		registerAllEnchantments();
		addRecipes();
		
	}
	
	@Override
	public void onDisable() {
		unregisterAllEnchantments();
	}
	
	@Override 
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
		
		switch (label.toLowerCase()) {
			case "guide":
				try {
					Player player = (Player) sender;
					sender.sendMessage(ChatColor.YELLOW + "Server Discord: " + ChatColor.BLUE +  "https://discord.gg/cmNaqav");
					sender.sendMessage(ChatColor.YELLOW + "Use " + ChatColor.GREEN + "/support" + ChatColor.YELLOW + " to learn how to help the server grow.");
					Commands.giveIntroBook(player);
					return true;
				} catch (Exception e){
					sender.sendMessage("This command is only for players to use!");
					return true;
				}
			case "support":
				try {
					@SuppressWarnings("unused")
					Player player = (Player) sender;
					sender.sendMessage(ChatColor.GREEN + "Vote for the server to get more players on: ");
					sender.sendMessage(ChatColor.BLUE + "https://www.planetminecraft.com/server/the-frontier-4391381/vote/");
					sender.sendMessage(ChatColor.BLUE + "https://minecraftservers.org/vote/563134");
					sender.sendMessage(ChatColor.BLUE + "https://minecraft-server-list.com/server/445788/vote/");
					sender.sendMessage(ChatColor.GREEN + "Patreon: " + ChatColor.RED + "not yet available");
					sender.sendMessage(ChatColor.GREEN + "Paypal: " + ChatColor.BLUE + "not yet available");
					return true;
				} catch (Exception e){
					sender.sendMessage("This command is only for players to use!");
					return true;
				}
			case "fcdebug":
				try {
					Player player = (Player) sender;
					
					if (player.getName().equalsIgnoreCase("Coldsteak")) {
						ItemStack smeltPick = new ItemStack(Material.DIAMOND_PICKAXE, 1);
						smeltPick.addUnsafeEnchantment(allCustomEnchantments.get(0), 1);
						player.getInventory().addItem(smeltPick);
						return true;
					} else {
						return true;
					}
				} catch (Exception e) {
					sender.sendMessage("This command is only for players to use!");
					return true;
				}
		}
		return false;
	}
	
	public void addRecipes() {
		getServer().addRecipe(Crafting.chargedCreeperEggRecipe());
		getServer().addRecipe(Crafting.enchGoldAppleRecipe());
		getServer().addRecipe(Crafting.sleepyEyeRecipe());
	}
	
	private void registerAllEnchantments() {
		for (Enchantment en : allCustomEnchantments) {
			registerEnchantment(en);
		}
	}
	
	
	private void unregisterAllEnchantments() {
		for (Enchantment en : allCustomEnchantments) {
			unregisterEnchantment(en);
		}
	}
	
	//Load custom enchantments
    public static void registerEnchantment(Enchantment enchantment) {
        boolean registered = true;
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchantment);
        } catch (Exception e) {
            registered = false;
            e.printStackTrace();
        }
        if(registered){
            Main.getPlugin(Main.class).getServer().getConsoleSender().sendMessage("Registered the enchantment: " + enchantment.getKey());
        }
    }
    //Unload custom enchantments
    @SuppressWarnings("deprecation")
	public static void unregisterEnchantment(Enchantment enchantment) {
    	try {
            Field keyField = Enchantment.class.getDeclaredField("byKey");
         
            keyField.setAccessible(true);
            @SuppressWarnings("unchecked")
            HashMap<NamespacedKey, Enchantment> byKey = (HashMap<NamespacedKey, Enchantment>) keyField.get(null);
         
            if(byKey.containsKey(enchantment.getKey())) {
                byKey.remove(enchantment.getKey());
            }
            Field nameField = Enchantment.class.getDeclaredField("byName");

            nameField.setAccessible(true);
            @SuppressWarnings("unchecked")
            HashMap<String, Enchantment> byName = (HashMap<String, Enchantment>) nameField.get(null);

            if(byName.containsKey(enchantment.getName())) {
                byName.remove(enchantment.getName());
            }
        } catch (Exception ignored) { }
    }
    
 // Disable the Power enchantment
    
}
