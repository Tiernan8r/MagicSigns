package me.Tiernanator.MagicSigns.Events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import me.Tiernanator.Colours.MessageColourer;
import me.Tiernanator.MagicSigns.MagicSignsMain;

public class SignColourer implements Listener {


	public SignColourer(MagicSignsMain main) {
	}

	@EventHandler
	public void onSignMake(SignChangeEvent event) {

		String[] allLines = event.getLines();

		for (int i = 0; i < allLines.length; i++) {

			String currentLine = allLines[i];
			
			String formattedMessage = MessageColourer.parseMessage(currentLine, ChatColor.BLACK);
			
			event.setLine(i, formattedMessage);
		}
	}
}
