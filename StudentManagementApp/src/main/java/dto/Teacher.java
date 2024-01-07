package dto;

public class Teacher 
{
	private String teacherName;
	private String teacherEmail;
	private String teacherPassword;
	private long teacherContact;
	
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherEmail() {
		return teacherEmail;
	}
	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}
	public String getTeacherPassword() {
		return teacherPassword;
	}
	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}
	public long getTeacherContact() {
		return teacherContact;
	}
	public void setTeacherContact(long teacherContact) {
		this.teacherContact = teacherContact;
	}
	@Override
	public String toString() {
		return "Teacher [teacherName=" + teacherName + ", teacherEmail=" + teacherEmail + ", teacherPassword="
				+ teacherPassword + ", teacherContact=" + teacherContact + "]";
	}
	
	

}
