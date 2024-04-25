package rock_scssior_paper.run;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import rock_scssior_paper.game.Game;
import rock_scssior_paper.item.Items;
import rock_scssior_paper.result.Ment;

public class GameRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Items items = new Items(); 
		Game game = new Game();
		Ment ment = new Ment();
		
		System.out.println(ment.getstart());
		
		Scanner scanner = new Scanner(System.in);
        System.out.println(ment.getInputRequest());        
        String userInput = scanner.nextLine();
        
		List<String> itemList = items.getItem();
		Collections.shuffle(itemList);
		String result = game.rpsGame(userInput, itemList.get(0));
		
		System.out.println(ment.getUserInput() + userInput);
		System.out.println(ment.getComputerInput() + itemList.get(0));
		System.out.print(result);
	}
}
