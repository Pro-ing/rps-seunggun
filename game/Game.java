package rock_scssior_paper.game;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import rock_scssior_paper.item.Items;
import rock_scssior_paper.result.Ment;

public class Game {
	
	public void gameStart(){
		
		Game game = new Game();
		Ment ment = new Ment();
        
		Scanner scanner = new Scanner(System.in);
		String inputVal = possibleInput();
		boolean startYn = true;  
        
		while(startYn) {
			System.out.println("게임시작");
			System.out.println(inputVal);
			System.out.println("값을 입력해주세요~");
			
			String userInput = scanner.nextLine();
	        
			String result = game.rpsGame(userInput);
			
			System.out.println(result);
			System.out.println("재시작 하시겠습니까?\nYes : Y");
			
			String restart = scanner.nextLine();
			if(!restart.equals("Y")) {
				startYn = false;
				System.out.print("게임을 종료합니다.");
			}
		}
	}
	
    public String rpsGame(String userInput){
		Items items = new Items();
		Ment ment = new Ment();
        Scanner scanner = new Scanner(System.in);
        
    	List<String> itemList = items.getItem();
		Collections.shuffle(itemList);
		String computerInput = itemList.get(0);
		String result = "";
    	
        
    	if (!validation(userInput)) {
    		System.out.println("입력하신 값이 올바르지 않습니다. \n값을 임으로 입력 할까요?\nYes : Y");
    		String RandomYn = scanner.nextLine();
    		
    		if(RandomYn.equals("Y")) {
    			Random random = new Random();
    			userInput = itemList.get(random.nextInt(itemList.size()-1));
    		} else {
        		return result;
    		}

    	}
    	
    	if(userInput.equals(computerInput)) {
    		result = ment.getDraw();
    	} else {
    		if(userInput.equals("Rock")) {
    			if(computerInput.equals("Scssior")) {
    				result = ment.getWin();
    			}
    			if(computerInput.equals("Paper")) {
    				result = ment.getLose();
    			}
    		}
    		
    		if(userInput.equals("Scssior")) {
    			if(computerInput.equals("Paper")) {
    				result = ment.getWin();
    			}
    			if(computerInput.equals("Rock")) {
    				result = ment.getLose();
    			}
    		}
    		
    		if(userInput.equals("Paper")) {
    			if(computerInput.equals("Rock")) {
    				result = ment.getWin();
    			}
    			if(computerInput.equals("Scssior")) {
    				result = ment.getLose();
    			}
    		}
    	}
    	
		result += "\n사용자 입력 값 : " + userInput + "\n컴퓨터 입력 값 : " +itemList.get(0);
		
    return result;
    
    };
    
    public boolean validation(String userInput) {
    	boolean Check = false;
    	Items items = new Items(); 
    	List<String> itemList = items.getItem();
    	
    	if(userInput.contains(" ")) {
    		userInput.replaceAll(" ", "");
    		System.out.println("입력하신 값에 공백이 존재하여 제거 했습니다^^");
    	};
        
    	for(int i=0; i<itemList.size(); i++) {
    		if(itemList.get(i).equals(userInput)) {
    			Check = true;
    			break;
    		}
    	};
    	
    	return Check;
    };
    
	
	public String possibleInput() {
		Items items = new Items();
		String inputVal = "입력 가능한 값 : ";
		
	    List<String> itemList = items.getItem();
		for(int i=0; i<itemList.size(); i++) {
			if(i == itemList.size()-1) {
				inputVal += itemList.get(i) + " 입니다.";
			} else {
				inputVal += itemList.get(i) + ", ";
			}
		}
		
	return inputVal;
	}
}
