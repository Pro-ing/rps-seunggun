package rock_scssior_paper.game;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import rock_scssior_paper.item.Items;
import rock_scssior_paper.type.ResultType;

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
    
    public String game(String userInput){
		String inputVal = possibleInput();
    	
		System.out.println("게임시작");
		System.out.println(inputVal);
	
    	Items items = new Items();
        
    	List<String> itemList = items.getItem();
		Collections.shuffle(itemList);
		String computerInput = itemList.get(0);
		
		System.out.println("\n사용자 입력 값 : " + userInput + "\n컴퓨터 입력 값 : " +itemList.get(0));
        
    	if (!validation(userInput)) {
    		if(randomYn) {
    			System.out.println("입력한 값이 잘못되어 값을 임의로 설정합니다.");
    			Random random = new Random();
    			userInput = itemList.get(random.nextInt(itemList.size()-1));
    		} else {
        		System.out.println("입력한 값이 잘못 되었습니다.");
    		}

    	}

    	if(userInput.equals(computerInput)) {
    		return ResultType.DRAW.ment();
    	} 
    	
		if(userInput.equals("Rock")) {
			if(computerInput.equals("Scssior")) {
				return ResultType.WIN.ment();
			}
			if(computerInput.equals("Paper")) {
				return ResultType.LOSE.ment();
			}
		}
		
		if(userInput.equals("Scssior")) {
			if(computerInput.equals("Paper")) {
				return ResultType.WIN.ment();
			}
			if(computerInput.equals("Rock")) {
				return ResultType.LOSE.ment();
			}
		}
		
		if(userInput.equals("Paper")) {
			if(computerInput.equals("Rock")) {
				return ResultType.WIN.ment();
			}
			if(computerInput.equals("Scssior")) {
				return ResultType.LOSE.ment();
			}
		}
		return "inputError";
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
