package me.Tiernanator.MagicSigns;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.material.MaterialData;

@SuppressWarnings("deprecation")
public class SignBlock {

	public static Block getAttachedToBlock(Sign sign) {

		if(sign.getType() != Material.LEGACY_WALL_SIGN) {
			return null;
		}

		//TODO: make this non reliant on data strings liable to be broken? If not already...

		// Get the block the sign is placed on in a convoluted way...

		//Get the data associated with the block
		MaterialData signData = sign.getData();
		//Convert this data to a string
		String dataString = signData.toString();
		//get the index in the string where it starts to mention the direction of the sign
		int facingIndex = dataString.indexOf("facing ") + "facing ".length();
		//get the last index of the sign
		int lastIndex = dataString.length();
		//Get the substring between these two indices
		String facingString = dataString.substring(facingIndex, lastIndex);

		//Get the face the sign is on based off of the substring above
		BlockFace signFace = BlockFace.valueOf(facingString);
		//Get the face behind it
		BlockFace oppositeFace = signFace.getOppositeFace();

		//Get the block of the sign
		Block signBlock = sign.getBlock();

		//return the block behind the sign in direction of blockface
		return signBlock.getRelative(oppositeFace);

	}

}
