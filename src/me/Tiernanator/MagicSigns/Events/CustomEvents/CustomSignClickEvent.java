package me.Tiernanator.MagicSigns.Events.CustomEvents;

import me.Tiernanator.Utilities.Players.SelectAction;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

//This is the custom custom menu click event that is called by OnPlayerMenuClick, it just contains functions that
//return all the values needed

public final class CustomSignClickEvent extends Event implements Cancellable {
	
	//handlers is a variable "handled"(...) by the server
    private static final HandlerList handlers = new HandlerList();
    //the SignBlock which was clicked
    private Sign sign;
    //the player who clicked
    private Player player;
    //The text on the sign
    private String[] signText;
    //Whether it was a left or right click
    private SelectAction selectAction;
    //Whether the event can continue or not is handled by isCancelled
    private boolean isCancelled;

    //constructor for the event that sets the variables
    public CustomSignClickEvent(Player player, Sign sign, SelectAction selectAction) {
        
    	this.player = player;
        this.sign = sign;
        this.selectAction = selectAction;
        
        this.signText = sign.getLines();
        
    }

    //return the location clicked
    public Sign getSign() {
        return this.sign;
    }
    //return the type of click
    public String[] getSignText() {
        return this.signText;
    }
    //get the player who done it
    public Player getPlayer() {
        return player;
    }
    public SelectAction getSelectAction() {
    	return this.selectAction;
    }
    //the next two are necessary for the server to use the event
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

	@Override
	public boolean isCancelled() {
		return isCancelled;
	}

	@Override
	public void setCancelled(boolean cancel) {
		isCancelled = cancel;
		
	}
}