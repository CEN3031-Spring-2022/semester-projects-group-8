package CombatSystem;

public class Player {
	String name;
	int maxHp;
	double attackPower;
	double defense;
	
	public Player() {
		this.name = "Hero";
		this.maxHp = 100;
		this.attackPower = 1;
		this.defense = 0.2;
	}
	
	public int getMaxHp() {
		return this.maxHp;
	}
	
	public double getAttackPower() {
		return this.attackPower;
	}
	
	public String getName() {
		return this.name;
	}
}
