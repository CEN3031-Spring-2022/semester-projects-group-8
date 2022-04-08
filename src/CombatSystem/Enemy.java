package CombatSystem;

public class Enemy {
	int id;
	String name;
	int maxHp;
	double attackPower;
	
	public Enemy() {
		this.id = -1;
		this.name = "error";
		this.maxHp = -1;
		this.attackPower = -1;
	}
	
	public Enemy(int id, String name, int maxHp, double attackPower) {
		this.id = id;
		this.name = name;
		this.maxHp = maxHp;
		this.attackPower = attackPower;
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
