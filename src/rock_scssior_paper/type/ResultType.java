package rock_scssior_paper.type;

public enum ResultType {
    WIN("이겼습니다."),
    DRAW("비겼습니다."),
    LOSE("졌습니다."),
	ERROR("ERROR발생");

	private final String ment;
	
	ResultType(String ment) {
        this.ment = ment;
    }

    public String ment() {
        return ment;
    }
}
