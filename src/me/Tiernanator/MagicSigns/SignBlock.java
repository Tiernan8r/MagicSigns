package me.Tiernanator.MagicSigns;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.material.MaterialData;

public class SignBlock {

	public static Block getAttachedToBlock(Sign sign) {

		if(sign.getType() != Material.WALL_SIGN) {
			return null;
		}
		
		// Get the block the sign is placed on in a convoluted way...
		MaterialData signData = sign.getData();
		String dataString = signData.toString();
		int facingIndex = dataString.indexOf("facing ") + "facing ".length();
		int lastIndex = dataString.length();
		String facingString = dataString.substring(facingIndex, lastIndex);

		BlockFace signFace = BlockFace.valueOf(facingString);
		BlockFace oppositeFace = signFace.getOppositeFace();

		Block signBlock = sign.getBlock();

		Block block = signBlock.getRelative(oppositeFace);

		return block;

	}

}
