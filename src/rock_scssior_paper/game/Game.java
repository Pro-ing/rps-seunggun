package rock_scssior_paper.game;

import java.util.List;

import rock_scssior_paper.item.Items;
import rock_scssior_paper.result.Ment;

public class Game {
		
    public String rpsGame(String userInput, String computerInput){
        Ment ment = new Ment();
    	String result = "";
        
    	if (!validation(userInput)) {
    		result = ment.getInputError();
    		return result;
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
   
    return result;
    
    };
    
    public boolean validation(String userInput) {
    	boolean Check = false;
    	Items items = new Items(); 
    	List<String> itemList = items.getItem();
        
    	for(int i=0; i<itemList.size(); i++) {
    		if(itemList.get(i).equals(userInput)) {
    			Check = true;
    			break;
    		}
    	};
    	
    	return Check;
    };
}
