package me.Tiernanator.MagicSigns;

import me.Tiernanator.MagicSigns.Events.BookColourer;
import me.Tiernanator.MagicSigns.Events.OnAnvilItemRename;
import me.Tiernanator.MagicSigns.Events.SignColourer;
import me.Tiernanator.MagicSigns.Events.SignInteractEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MagicSignsMain extends JavaPlugin {
	
	@Override
	public void onEnable() {
		registerEvents();
	}


	public void registerEvents() {

		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new SignInteractEvent(this), this);
		pm.registerEvents(new SignColourer(), this);
		
		pm.registerEvents(new OnAnvilItemRename(), this);
		pm.registerEvents(new BookColourer(), this);
		
	}
}
