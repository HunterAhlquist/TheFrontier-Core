package com.hunterahlquist.TheFrontier_Core.Base;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;


public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		
		
		getServer().getPluginManager().registerEvents(new MobDrops(), this);
		getServer().getPluginManager().registerEvents(new ChargedCreeperEgg(), this);
		getServer().getPluginManager().registerEvents(new PlayerSpawning(), this);
		
		
		addRecipes();
		
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
		}
		return false;
	}
	
	public void addRecipes() {
		getServer().addRecipe(Crafting.chargedCreeperEggRecipe());
		getServer().addRecipe(Crafting.enchGoldAppleRecipe());
	}
	
	
}
