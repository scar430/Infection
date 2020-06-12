package Infection.transformative;

import org.bukkit.entity.EntityType;

public class Transformative {
	
	public EntityType carrier;
	public float chance;
	public Stage[] stages;
	
	public Transformative(EntityType newCarrier, float newChance, Stage[] newStages) {
		carrier = newCarrier;
		chance = newChance;
		stages = newStages;
	}
}
