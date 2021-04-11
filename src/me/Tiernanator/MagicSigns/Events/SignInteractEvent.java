package me.Tiernanator.MagicSigns.Events;

import me.Tiernanator.MagicSigns.Events.CustomEvents.CustomSignClickEvent;
import me.Tiernanator.MagicSigns.MagicSignsMain;
import me.Tiernanator.Utilities.Players.SelectAction;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignInteractEvent implements Listener {

	private MagicSignsMain plugin;

	public SignInteractEvent(MagicSignsMain main) {
		plugin = main;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onSignInteract(PlayerInteractEvent event) {

		Block block = event.getClickedBlock();
		if(block == null) {
			return;
		}
		Material material = block.getType();

		if(material != Material.LEGACY_SIGN && material != Material.LEGACY_SIGN_POST && material != Material.LEGACY_WALL_SIGN) {
			return;
		}

		if (!(block.getState() instanceof Sign)) {
			return;
		}
		//Get whether the player right or left clicked on the sign
		Action action = event.getAction();
		SelectAction selectAction = SelectAction.getSelectAction(action);

		//Get the sign clicked
		Sign sign = (Sign) event.getClickedBlock().getState();

		//Get the player
		Player player = event.getPlayer();

		//Create the sign click event to call
		CustomSignClickEvent signClickEvent = new CustomSignClickEvent(player,
				sign, selectAction);
		//Call the event and set it to the cancelled state or not
		plugin.getServer().getPluginManager().callEvent(signClickEvent);
		event.setCancelled(signClickEvent.isCancelled());

	}
}
