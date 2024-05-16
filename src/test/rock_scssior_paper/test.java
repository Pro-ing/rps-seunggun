package test.rock_scssior_paper;

import org.junit.jupiter.api.Test;

import rock_scssior_paper.game.IGame;
import rock_scssior_paper.game.RpsGame;
import rock_scssior_paper.user.Computer;
import rock_scssior_paper.user.IPlayer;
import rock_scssior_paper.user.User;

class test {

	@Test
	void test() {
        
		IGame rpgGame = new RpsGame();
		rpgGame.randomItem(false);
		rpgGame.game("Rock");
		
	}

}
