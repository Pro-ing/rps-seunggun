package rock_scssior_paper.game;

import rock_scssior_paper.type.ResultType;

public interface IGame {
    
	// 게임 실행 로직
	// 결과값을 반환
	public ResultType game(String userInput);
	
	// 사용자 입력 값 유효성 체크
	public boolean validation(String userInput);

}

