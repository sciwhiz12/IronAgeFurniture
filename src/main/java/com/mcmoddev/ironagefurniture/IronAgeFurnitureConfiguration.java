package com.mcmoddev.ironagefurniture;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class IronAgeFurnitureConfiguration {	
	public static boolean GENERATE_CLASSIC_CHAIRS = true;
	public static boolean GENERATE_SHIELD_CHAIRS = true;
	public static boolean GENERATE_SHORT_STOOLS = true;
	public static boolean GENERATE_TALL_STOOLS = true;
	
	public static boolean INTEGRATION_BIOMESOPLENTY = true;
	public static boolean INTEGRATION_NATURA = true;
	
	public static void init(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
    	config.load();
    	
    	INTEGRATION_BIOMESOPLENTY = config.getBoolean("INTEGRATION_BIOMESOPLENTY", "integration", INTEGRATION_BIOMESOPLENTY, "If true, then furniture for BiomesOPlenty will be generated");
    	INTEGRATION_NATURA = config.getBoolean("INTEGRATION_NATURA", "integration", INTEGRATION_NATURA, "If true, then furniture for Natura will be generated");
    	
    	GENERATE_SHIELD_CHAIRS = config.getBoolean("GENERATE_SHIELD_CHAIRS", "options", GENERATE_SHIELD_CHAIRS, "If true, then shield chairs will be generated");
		GENERATE_CLASSIC_CHAIRS = config.getBoolean("GENERATE_CLASSIC_CHAIRS", "options", GENERATE_CLASSIC_CHAIRS, "If true, then classic chairs will be generated");
	
		GENERATE_SHORT_STOOLS = config.getBoolean("GENERATE_SHORT_STOOLS", "options", GENERATE_SHORT_STOOLS, "If true, then short stools will be generated");
		GENERATE_TALL_STOOLS = config.getBoolean("GENERATE_TALL_STOOLS", "options", GENERATE_TALL_STOOLS, "If true, then tall stools will be generated");
		
		config.save();
	}
}