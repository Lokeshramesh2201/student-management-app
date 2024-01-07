package dto;

public class Student 
{
	private int studentRollNo;
	private String studentName;
	private String studentStd;
	private String studentAddress;
	private long studentContact;
	
	public int getStudentRollNo() {
		return studentRollNo;
	}
	public void setStudentRollNo(int studentRollNo) {
		this.studentRollNo = studentRollNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentStd() {
		return studentStd;
	}
	public void setStudentStd(String studentStd) {
		this.studentStd = studentStd;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public long getStudentContact() {
		return studentContact;
	}
	public void setStudentContact(long studentContact) {
		this.studentContact = studentContact;
	}
	@Override
	public String toString() {
		return "Student [studentRollNo=" + studentRollNo + ", studentName=" + studentName + ", studentStd=" + studentStd
				+ ", studentAddress=" + studentAddress + ", studentContact=" + studentContact + "]";
	}
	
	
	
}
