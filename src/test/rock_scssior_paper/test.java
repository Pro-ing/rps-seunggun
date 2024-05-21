package test.rock_scssior_paper;

import org.junit.jupiter.api.Test;

import rock_scssior_paper.game.IGame;
import rock_scssior_paper.game.RpsGame;
import rock_scssior_paper.type.ResultType;

class test {

	@Test
	void test() {
        
		IGame rpgGame = new RpsGame();
		ResultType result = rpgGame.game("Rock");
    	
		System.out.println(result.ment());
		
		System.out.println("\n게임을 종료합니다.");
		
	}

}
