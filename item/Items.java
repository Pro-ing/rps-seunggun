package rock_scssior_paper.item;

import java.util.ArrayList;
import java.util.List;

public class Items {
	private String item1 = "Rock";
	private String item2 = "Scssior";
	private String item3 = "Paper";
	
	public List<String> getItem() {
		List<String> items = new ArrayList<>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		
		return items;
	}
}
