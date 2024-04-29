package rock_scssior_paper.result;

import java.util.List;

import rock_scssior_paper.item.Items;

public class Ment {
	private String win = "이겼습니다";
	private String lose = "졌습니다";
	private String draw = "비겼습니다";
	private String inputError = "입력하신 값이 올바르지 않습니다.";
	
	public String getWin() {
		return win;
	}
	
	public String getLose() {
		return lose;
	}
	
	public String getDraw() {
		return draw;
	}
	
	public String getInputError() {
		return inputError;
	}
}
