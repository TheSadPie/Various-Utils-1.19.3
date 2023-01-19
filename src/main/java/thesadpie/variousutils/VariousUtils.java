package thesadpie.variousutils;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thesadpie.variousutils.item.ModItems;

public class VariousUtils implements ModInitializer {
	public static final String MOD_ID = "variousutils";
	public static final Logger LOGGER = LoggerFactory.getLogger("variousutils");

	@Override
	public void onInitialize() {

		ModItems.registerModItems();

	}
}