package me.Tiernanator.MagicSigns.Events;

import me.Tiernanator.Utilities.Colours.MessageColourer;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;

import java.util.List;

//Adds colour codes to the books
public class BookColourer implements Listener {

	@EventHandler
	public void onSignMake(PlayerEditBookEvent event) {

		//If the book isn't being signed off, don't do the colour codes
		if(!event.isSigning()) {
			return;
		}

		//Get the metadata of the book, which contains it's text
		BookMeta bookMeta = event.getNewBookMeta();
		//Get all the pages on the book
		List<String> pages = bookMeta.getPages();

		//Iterate over the pages
		for(String i : pages) {

			//The book pages are counted from 1 instead of from 0
			int index = pages.indexOf(i) + 1;
			//Format the colours and replace the text
			String formattedPage = MessageColourer.parseMessage(i, ChatColor.BLACK);
			bookMeta.setPage(index, formattedPage);
			
		}
		//Replace the metadata
		event.setNewBookMeta(bookMeta);
		
	}
}
