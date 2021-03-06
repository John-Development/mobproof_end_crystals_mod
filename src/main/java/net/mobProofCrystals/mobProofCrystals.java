package net.mobProofCrystals;

import java.io.IOException;

import net.fabricmc.api.ModInitializer;
import net.mobProofCrystals.commands.GameRuleCustomCommand;
import net.mobProofCrystals.util.PropertiesCache;

public class mobProofCrystals implements ModInitializer {

  final public static String DEF_RAD = "32";
  final public static String DEF_LIM_DISTANCE = "1";
  final public static String DEF_CRYSTAL_NAME = "";
  @Override
  public void onInitialize() {
    try {
      PropertiesCache cache = PropertiesCache.getInstance();
      if (cache.getProperty("radius") == null) {
        cache.setProperty("radius", DEF_RAD);
      }
      if (cache.getProperty("lower-limit-distance") == null){
        cache.setProperty("lower-limit-distance", DEF_LIM_DISTANCE);
      }
      if (cache.getProperty("crystal-name") == null){
        cache.setProperty("crystal-name", DEF_CRYSTAL_NAME);
      }
      
      //Write to the file
      PropertiesCache.getInstance().flush();

      // Init commands
      GameRuleCustomCommand.getInstance().init();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
