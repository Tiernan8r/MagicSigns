package me.Tiernanator.MagicSigns.Events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.Tiernanator.MagicSigns.MagicSignsMain;
import me.Tiernanator.MagicSigns.Events.CustomEvents.CustomSignClickEvent;
import me.Tiernanator.Utilities.Players.SelectAction;

public class SignInteractEvent implements Listener {

	private MagicSignsMain plugin;

	public SignInteractEvent(MagicSignsMain main) {
		plugin = main;
	}

	@EventHandler
	public void onSignInteract(PlayerInteractEvent event) {

		Block block = event.getClickedBlock();
		if(block == null) {
			return;
		}
		Material material = block.getType();
		if(material != Material.SIGN && material != Material.SIGN_POST && material != Material.WALL_SIGN) {
			return;
		}
		
		if (!(block.getState() instanceof Sign)) {
			return;
		}
		Action action = event.getAction();
		SelectAction selectAction = SelectAction.getSelectAction(action);

		Sign sign = (Sign) event.getClickedBlock().getState();

		Player player = event.getPlayer();

		CustomSignClickEvent signClickEvent = new CustomSignClickEvent(player,
				sign, selectAction);
		plugin.getServer().getPluginManager().callEvent(signClickEvent);
		event.setCancelled(signClickEvent.isCancelled());
		// HeadsUpDisplay display = new HeadsUpDisplay();
		// display.displayTextBar("WOOOOOOOOOO", player);

		// PacketPlayOutNamedEntitySpawn npc = new
		// PacketPlayOutNamedEntitySpawn(p.getHandle());
		//
		// //the a field used to be public, we'll need to use reflection to
		// access:
		// try {
		// Field field = npc.getClass().getDeclaredField("a");
		// field.setAccessible(true);// allows us to access the field
		//
		// field.setInt(npc, 123);// sets the field to an integer
		// field.setAccessible(!field.isAccessible());//we want to stop
		// accessing this now
		// } catch(Exception x) {
		// x.printStackTrace();
		// }
		//
		// //now comes the sending
		// p.getHandle().playerConnection.sendPacket(npc);

		// Packet packet = new

		// ((CraftPlayer) player).getHandle().playerConnection.sendPacket();

		// event.getPlayer().sendMessage(ChatColor.BLUE + "Poof!");

		// sign.update();

	}
}
