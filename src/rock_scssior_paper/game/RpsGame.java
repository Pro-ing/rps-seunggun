package rock_scssior_paper.game;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import rock_scssior_paper.item.Items;

public class RpsGame implements IGame{
	
	public static boolean startYn = true;
	
    public void startGame(){
        
		Scanner scanner = new Scanner(System.in);
		String inputVal = possibleInput();
        
		while(startYn) {
			System.out.println("게임시작");
			System.out.println(inputVal);
			System.out.println("값을 입력해주세요~");
			
			String userInput = scanner.nextLine();
			rpsGame(userInput);
		}
	}
    
    public void rpsGame(String userInput){
    	String win = "이겼습니다";
    	String lose = "졌습니다";
    	String draw = "비겼습니다";
    	
    	Items items = new Items();
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
        		endGame(result);
    		}

    	}
    	
    	if(userInput.equals(computerInput)) {
    		result = draw;
    	} else {
    		if(userInput.equals("Rock")) {
    			if(computerInput.equals("Scssior")) {
    				result = win;
    			}
    			if(computerInput.equals("Paper")) {
    				result = lose;
    			}
    		}
    		
    		if(userInput.equals("Scssior")) {
    			if(computerInput.equals("Paper")) {
    				result = win;
    			}
    			if(computerInput.equals("Rock")) {
    				result = lose;
    			}
    		}
    		
    		if(userInput.equals("Paper")) {
    			if(computerInput.equals("Rock")) {
    				result = win;
    			}
    			if(computerInput.equals("Scssior")) {
    				result = lose;
    			}
    		}
    	}
    	
		result += "\n사용자 입력 값 : " + userInput + "\n컴퓨터 입력 값 : " +itemList.get(0);
		
		endGame(result);
    
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
	
    public void endGame(String result){
    	Scanner scanner = new Scanner(System.in);
		System.out.println(result);
		System.out.println("재시작 하시겠습니까?\nYes : Y");
		
		String restart = scanner.nextLine();
		if(!restart.equals("Y")) {
			startYn = false;
		}
    }
}
