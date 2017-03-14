package me.Tiernanator.MagicSigns.Events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;

import me.Tiernanator.Colours.MessageColourer;
import me.Tiernanator.MagicSigns.Main;
import me.Tiernanator.Utilities.Items.Item;

public class OnAnvilItemRename implements Listener {


	public OnAnvilItemRename(Main main) {
	}

	@EventHandler
	public void onItemRename(InventoryClickEvent event) {

		if(event.getAction() != InventoryAction.PICKUP_ALL) {
			return;
		}
		
		if(!(event.getInventory() instanceof AnvilInventory)) {
			return;
		}
		ItemStack item = event.getCurrentItem();
		if(!(item.getItemMeta().hasDisplayName())) {
			return;
		}
		String unformattedItemName = item.getItemMeta().getDisplayName();
		String formattedItemName = MessageColourer.parseMessage(unformattedItemName, ChatColor.WHITE);
		Item.renameItem(item, formattedItemName);
	}
}
