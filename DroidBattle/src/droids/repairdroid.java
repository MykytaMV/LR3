package droids;

public class repairdroid extends basedroid {

	public repairdroid(String name, int health, int damage, int armor) {
		super(name, health, damage, armor);
	}
	
	public int Repair(basedroid droid) {
		droid.AddHealth(this.GetDamage());
		droid.AddArmor(1);
		return this.GetDamage();
	}

}
