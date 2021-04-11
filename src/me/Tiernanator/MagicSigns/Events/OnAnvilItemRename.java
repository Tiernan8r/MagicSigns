package me.Tiernanator.MagicSigns.Events;

import me.Tiernanator.Utilities.Colours.MessageColourer;
import me.Tiernanator.Utilities.Items.ItemUtility;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;

public class OnAnvilItemRename implements Listener {

    @EventHandler
    public void onItemRename(InventoryClickEvent event) {


        if (event.getAction() != InventoryAction.PICKUP_ALL) {
            return;
        }

        if (!(event.getInventory() instanceof AnvilInventory)) {
            return;
        }
        ItemStack item = event.getCurrentItem();
        //If the item isn't being renamed, return
        if (!(item.getItemMeta().hasDisplayName())) {
            return;
        }
        //Get the new name of the item and format it with the colour codes
        String unformattedItemName = item.getItemMeta().getDisplayName();
        String formattedItemName = MessageColourer.parseMessage(unformattedItemName, ChatColor.WHITE);
        ItemUtility.renameItem(item, formattedItemName);
    }
}
