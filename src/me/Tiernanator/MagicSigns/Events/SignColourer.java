package me.Tiernanator.MagicSigns.Events;

import me.Tiernanator.Utilities.Colours.MessageColourer;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

//Converts colour codes typed to a sign to their correct colour
public class SignColourer implements Listener {

    @EventHandler
    public void onSignMake(SignChangeEvent event) {

        //Get the lines written to the sign
        String[] allLines = event.getLines();

        //Iterate over all the lines
        for (int i = 0; i < allLines.length; i++) {

            //Get the line
            String currentLine = allLines[i];

            //Format any of the colour codes to the correct colour
            String formattedMessage = MessageColourer.parseMessage(currentLine, ChatColor.BLACK);
            //Replace the lines with the new ones
            event.setLine(i, formattedMessage);
        }
    }

}
