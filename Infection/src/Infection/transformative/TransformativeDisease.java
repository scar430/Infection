package Infection.transformative;

import org.bukkit.entity.EntityType;

public class TransformativeDisease {
	
	public EntityType carrier;
	public float chance;
	public Stage[] stages;
	
	public TransformativeDisease(EntityType newCarrier, float newChance, Stage[] newStages) {
		carrier = newCarrier;
		chance = newChance;
		stages = newStages;
	}
}
