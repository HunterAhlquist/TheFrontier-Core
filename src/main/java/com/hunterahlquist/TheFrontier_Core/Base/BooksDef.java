package com.hunterahlquist.TheFrontier_Core.Base;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class BooksDef {
	public static ItemStack getIntroBook() {
		ItemStack finalBook = new ItemStack(Material.WRITTEN_BOOK, 1);
		
		BookMeta guideMeta = (BookMeta) finalBook.getItemMeta();
		
		guideMeta.setTitle("An Introduction to the Frontier");
		guideMeta.setAuthor("The Owners");
		
		guideMeta.addPage("A Guide to the Frontier\n\nWhat is this server?\n\nThis is what we call an 'anarchy-lite' server. Much like the infamous 2b2t there are NO RULES. Lie, cheat, steal, anything that remains contained within the server is fair game.");
		guideMeta.addPage("But where the 'lite' part comes in is where some changes are made, commands are added, mechanics are changed, and gameplay is expanded.\n\n");
		guideMeta.addPage("Factions\n\nMake it harder for people to raid, and grief your base.\n\nUse the command\n/f\nto see its basic uses.");
		guideMeta.addPage("Trading\n\nShift right-click another player to trade with them.\n");
		guideMeta.addPage("Private Messaging\n\nUse\n /msg [player] [text] \nTo send a private message.\n");
		guideMeta.addPage("Ignoring Players\n\nUse\n /ignore [player] \nTo stop a player from clogging your chat.\n");
		guideMeta.addPage("Killing Yourself\n\nUse\n /suicide \nTo take the easy way out and end your own (player's) life!\n");
		guideMeta.addPage("Homes\n\nTo set a home for yourself use\n/sethome\n\nTo teleport to your home use\n/home\n\nThere is a 5 second delay when teleporting.");
		guideMeta.addPage("Spawner Eggs\n\nSome mobs will have a 1% chance to drop a spawn egg of itself.");
		guideMeta.addPage("TIPS\n\nDistance is your best defense, the server has a 20mil by 20mil sized map, so travel far.\n\nBe careful who you trust, since there are no rules, they can backstab you at any time.");
		guideMeta.addPage("\n\n\n\n\n\n\n\n\n\n\nDont forget.\nThis is just a silly block game.");
		
		finalBook.setItemMeta(guideMeta);
		
		return finalBook;
	}
}
