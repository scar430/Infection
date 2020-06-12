package Infection;

import org.bukkit.plugin.java.JavaPlugin;

import Infection.carrier.CarrierListener;
import Infection.cure.CureListener;
import Infection.transformative.TransformativeListener;

public class Infection extends JavaPlugin {
	
	private TransformativeListener tListener = new TransformativeListener(this);
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new CarrierListener(), this);
		getServer().getPluginManager().registerEvents(tListener, this);
		getServer().getPluginManager().registerEvents(new CureListener(tListener, this), this);
	}
	
	@Override
	public void onDisable() {
		
	}

}
