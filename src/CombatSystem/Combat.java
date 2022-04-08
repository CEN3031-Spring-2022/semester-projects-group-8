package CombatSystem;

import java.util.Scanner;

public class Combat {
	Enemy[] enemyList;
	int playerCurrentHealth = 0;
	int enemyCurrentHealth = 0;
	int baseHitDamage = 10;
	Player player;
	Enemy currentEnemy;
	Scanner kb = new Scanner(System.in);
	public Combat(Enemy[] enemyList, int ENEMY_LIST_SIZE) {
		this.enemyList = enemyList;
		this.player = new Player();
	}
	
	public void initiateCombat(int enemyId) {
		this.currentEnemy = this.enemyList[enemyId];
		playerCurrentHealth = player.getMaxHp();
		enemyCurrentHealth = currentEnemy.getMaxHp();
		int playerInput = -1;
		System.out.println("You enter combat with " + currentEnemy.getName());
		while(this.playerCurrentHealth > 0 && this.enemyCurrentHealth > 0) {
			System.out.println("What would you like to do?");
			System.out.println("1. Attack");
			System.out.println("2. Run away");
			playerInput = this.kb.nextInt();
			switch (playerInput) {
				case 1: playerAttack();
						break;
				case 2: enemyCurrentHealth = -999;
						break;
				default: System.out.println("You did something rather stupid. Nothing happened.");
						break;
			}
			enemyAttack();
		}
		if (enemyCurrentHealth == -999) {
			System.out.println("You ran away.");
		} else if (playerCurrentHealth <= 0) {
			System.out.println("You were defeated by " + currentEnemy.getName());
		} else if (enemyCurrentHealth <= 0) {
			System.out.println("Congratulations, you beat " + currentEnemy.getName());
		}
	}
	
	public void playerAttack() {
		this.enemyCurrentHealth -= player.getAttackPower() * this.baseHitDamage;
		System.out.println(player.getName() + " hit " + currentEnemy.getName() + " for " + (player.getAttackPower() * this.baseHitDamage) + " damage.");
	}
	public void enemyAttack() {
		this.playerCurrentHealth -= currentEnemy.getAttackPower() * this.baseHitDamage;
		System.out.println(currentEnemy.getName() + " decides to strike.");
		System.out.println(player.getName() + " was hit by " + currentEnemy.getName() + " for " + (currentEnemy.getAttackPower() * this.baseHitDamage) + " damage.");
	}
}
