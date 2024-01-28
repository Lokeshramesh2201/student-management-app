package com.qsp.m7.studentarraylist;

public class Student {
private int sId;
private String sName;
private byte age;
public int getsId() {
	return sId;
}
public void setsId(int sId) {
	this.sId = sId;
}
public String getsName() {
	return sName;
}
public void setsName(String sName) {
	this.sName = sName;
}
public byte getAge() {
	return age;
}
public void setAge(byte age) {
	this.age = age;
}
@Override
public String toString() {
	return "Student [sId=" + sId + ", sName=" + sName + ", age=" + age + "]";
}
public Student(int sId, String sName, byte age) {
	super();
	this.sId = sId;
	this.sName = sName;
	this.age = age;
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}

}
