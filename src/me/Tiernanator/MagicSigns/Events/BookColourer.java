package me.Tiernanator.MagicSigns.Events;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;

import me.Tiernanator.Colours.MessageColourer;
import me.Tiernanator.MagicSigns.Main;

public class BookColourer implements Listener {


	public BookColourer(Main main) {
	}

	@EventHandler
	public void onSignMake(PlayerEditBookEvent event) {
		
		if(!event.isSigning()) {
			return;
		}
		
		BookMeta bookMeta = event.getNewBookMeta();
		List<String> pages = bookMeta.getPages();
		
		for(String i : pages) {
			
			int index = pages.indexOf(i) + 1;
			String formattedPage = MessageColourer.parseMessage(i, ChatColor.BLACK);
			bookMeta.setPage(index, formattedPage);
			
		}
		event.setNewBookMeta(bookMeta);
		
	}
}
