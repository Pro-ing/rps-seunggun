package rock_scssior_paper.run;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import rock_scssior_paper.game.Game;
import rock_scssior_paper.item.Items;
import rock_scssior_paper.result.Ment;

public class Run {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Items items = new Items(); 
		Game game = new Game();
		Ment ment = new Ment();
		
		System.out.println(ment.getstart());
		String inputVal = "입력 가능한 값 : ";
		
        List<String> itemList = items.getItem();
		for(int i=0; i<itemList.size(); i++) {
			if(i == itemList.size()-1) {
				inputVal += itemList.get(i) + " 입니다.";
			} else {
				inputVal += itemList.get(i) + ", ";
			}

		}
		
		System.out.println(inputVal);
		Scanner scanner = new Scanner(System.in);
        System.out.println(ment.getInputRequest());        
        String userInput = scanner.nextLine();
        

		Collections.shuffle(itemList);
		String result = game.rpsGame(userInput, itemList.get(0));
		
		System.out.println(ment.getUserInput() + userInput);
		System.out.println(ment.getComputerInput() + itemList.get(0));
		System.out.print(result);
	}
}
