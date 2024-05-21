package rock_scssior_paper.game;

import java.util.List;
import java.util.Random;

import rock_scssior_paper.item.Items;
import rock_scssior_paper.type.ResultType;

public class RpsGame implements IGame{
	
	public static boolean restartYn = false;
    
    public ResultType game(String userInput){
		String inputVal = possibleInput();
    	
		System.out.println("게임시작");
		System.out.println(inputVal);
	
    	Items items = new Items();
        
    	List<String> itemList = items.getItem();
    	Random random = new Random();
		String computerInput = itemList.get(random.nextInt(itemList.size()-1));
		
		System.out.println("\n사용자 입력 값 : " + userInput + "\n컴퓨터 입력 값 : " +itemList.get(0));
        
    	if (!validation(userInput)) {
        		System.out.println("입력한 값이 잘못 되었습니다.");
    	}

    	if(userInput.equals(computerInput)) {
    		return ResultType.DRAW;
    	} 
    	
		if(userInput.equals("Rock")) {
			if(computerInput.equals("Scssior")) {
				return ResultType.WIN;
			}
			if(computerInput.equals("Paper")) {
				return ResultType.LOSE;
			}
		}
		
		if(userInput.equals("Scssior")) {
			if(computerInput.equals("Paper")) {
				return ResultType.WIN;
			}
			if(computerInput.equals("Rock")) {
				return ResultType.LOSE;
			}
		}
		
		if(userInput.equals("Paper")) {
			if(computerInput.equals("Rock")) {
				return ResultType.WIN;
			}
			if(computerInput.equals("Scssior")) {
				return ResultType.LOSE;
			}
		}
		return ResultType.ERROR;
	};
    
    public boolean validation(String userInput) {
    	Items items = new Items(); 
    	List<String> itemList = items.getItem();
    	
    	if(userInput.contains(" ")) {
    		userInput.replaceAll("\\s", "");
    	};
        
    	for(int i=0; i<itemList.size(); i++) {
    		if(itemList.get(i).equals(userInput)) {
    			return true;
    		}
    	};
    	
    	return false;
    };
    
	
	public String possibleInput() {
		Items items = new Items();
		String inputVal = "입력 가능한 값 : ";
		
	    List<String> itemList = items.getItem();
	    inputVal += String.join(",",itemList);
	    inputVal += " 입니다.";
		
	return inputVal;
	}
}
