package rock_scssior_paper.game;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import rock_scssior_paper.item.Items;

public class RpsGame implements IGame{
	
	private static String userInput = "";
	public static boolean restartYn = false;
	public static boolean randomYn = false;
    
    public void InputItem(String item){
        
		String inputVal = possibleInput();
		userInput = item;
	
		System.out.println("게임시작");
		System.out.println(inputVal);
		System.out.println("값을 입력해주세요~");
		
		game(userInput);
		
	}
    
    public void game(String userInput){
    	String win = "이겼습니다\n";
    	String lose = "졌습니다\n";
    	String draw = "비겼습니다\n";
		String inputVal = possibleInput();
    	
		System.out.println("게임시작");
		System.out.println(inputVal);
	
    	Items items = new Items();
        
    	List<String> itemList = items.getItem();
		Collections.shuffle(itemList);
		String computerInput = itemList.get(0);
		String result = "";
    	
        
    	if (!validation(userInput)) {
    		if(randomYn) {
    			System.out.println("입력한 값이 잘못되어 값을 임의로 설정합니다.");
    			Random random = new Random();
    			userInput = itemList.get(random.nextInt(itemList.size()-1));
    		} else {
        		System.out.println("값을 다시 입력해 주세요.");
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
    	
		result += "사용자 입력 값 : " + userInput + "\n컴퓨터 입력 값 : " +itemList.get(0);
		System.out.println(result);
		
		System.out.println("게임을 종료합니다.");
	};
    
    public boolean validation(String userInput) {
    	boolean Check = false;
    	Items items = new Items(); 
    	List<String> itemList = items.getItem();
    	
    	if(userInput.contains(" ")) {
    		userInput.replaceAll(" ", "");
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
	
    public void randomItem(boolean yn){
    	if(yn) {
    		randomYn = true;
    	} else {
    		randomYn = false;
    	}
    }
}
