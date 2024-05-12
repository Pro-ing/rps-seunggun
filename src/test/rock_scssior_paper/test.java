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
		User user1 = new User();
		user1.setName("승건1");

		User user2= new User();
		user2.setName("승건2");
        
        Computer computer1 = new Computer();
        computer1.setName();
        
        Computer computer2 = new Computer();
        computer2.setName();
        
		IGame game = new RpsGame();
		game.playGame();
	}

}
