package Infection;

import org.bukkit.plugin.java.JavaPlugin;

import Infection.carrier.CarrierListener;
import Infection.transformative.TransformativeListener;

public class Infection extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new CarrierListener(), this);
		getServer().getPluginManager().registerEvents(new TransformativeListener(this), this);
	}
	
	@Override
	public void onDisable() {
		
	}

}
