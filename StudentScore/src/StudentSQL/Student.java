package StudentSQL;

import java.util.Arrays;

public class Student implements Comparable<Student>{
	private int stdNum;
	private String email ;
	private int[] courseScore = new int[5];
	private int totalScore;
	private String profCode;
	private String achv;
	private String localCode;
	public int getStdNum() {
		return stdNum;
	}
	public void setStdNum(int stdNum) {
		this.stdNum = stdNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int[] getCourseScore() {
		return courseScore;
	}
	public int getCourseScore(int num) {
		return courseScore[num];
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
	public String getProfCode() {
		return profCode;
	}
	public void setProfCode(String profCode) {
		this.profCode = profCode;
	}
	public String getAchv() {
		return achv;
	}
	public void setAchv(String achv) {
		this.achv = achv;
	}
	public String getLocalCode() {
		return localCode;
	}
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	@Override
	public String toString() {
		return "Student [stdNum=" + stdNum + ", email=" + email + ", courseScore=" + Arrays.toString(courseScore)
				+ ", totalScore=" + totalScore + ", profCode=" + profCode + ", achv=" + achv + ", localCode="
				+ localCode + "]";
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		
		return (getCourseScore(0) + getCourseScore(1)) - (o.getCourseScore(0) + o.getCourseScore(1));
	}
	
	
	
}
