package ScoreService;

public class Student {
	private int stdNum;
	private String[] email = new String[4];
	private int[] courseScore = new int[5];
	private int totalScore;
	private char profCode;
	private char achv;
	private char localCode;
	public int getStdNum() {
		return stdNum;
	}
	public void setStdNum(int stdNum) {
		this.stdNum = stdNum;
	}
	public String[] getEmail() {
		return email;
	}
	public void setEmail(String[] email) {
		this.email = email;
	}
	public int[] getCourseScore() {
		return courseScore;
	}
	public void setCourseScore(int[] courseScore) {
		this.courseScore = courseScore;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public char getProfCode() {
		return profCode;
	}
	public void setProfCode(char profCode) {
		this.profCode = profCode;
	}
	public char getAchv() {
		return achv;
	}
	public void setAchv(char achv) {
		this.achv = achv;
	}
	public char getLocalCode() {
		return localCode;
	}
	public void setLocalCode(char localCode) {
		this.localCode = localCode;
	}
	
	
}
