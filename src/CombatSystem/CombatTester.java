package CombatSystem;

public class CombatTester {

	public static void main(String[] args) {
		Enemy trainingDummy = new Enemy(0, "Training Dummy", 100, 0);
		Enemy snail = new Enemy(1, "Disgruntled Snail", 45, 0.1);
		Enemy[] enemyArray = {trainingDummy, snail};
		Combat combat = new Combat(enemyArray, enemyArray.length);
		combat.initiateCombat(0);
	}

}
