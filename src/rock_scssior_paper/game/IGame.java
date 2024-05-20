package rock_scssior_paper.game;

public interface IGame {
    
	// 게임 실행 로직
	// 결과값을 반환
	public String game(String userInput);
	
	// 사용자 입력 값
	public void InputItem(String item);
	
	// 사용자 입력 값 유효성 체크
	public boolean validation(String userInput);
	
	// param값이 잘못되었을때 임의로 값을 설정해줌
	public void randomItem(boolean yn);
}

