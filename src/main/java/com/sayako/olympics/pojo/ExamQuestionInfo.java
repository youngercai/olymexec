package com.sayako.olympics.pojo;

import java.io.Serializable;
import java.util.Date;

public class ExamQuestionInfo implements Serializable {

	private static final long serialVersionUID = -4446700159195488940L;

	private Integer serialNo;

	private Integer examNo;

	private String examName;

	private String examDesc;

	private String examType;

	private String inputInfo;

	private String outputInfo;

	private String inputDemo;

	private String outputDemo;

	private String examSource;

	private String createUser;

	private Date createTime;

	private String validStatus;
	
	private String reverse1;
	
	private String reverse2;
	
	private String reverse3;

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public Integer getExamNo() {
		return examNo;
	}

	public void setExamNo(Integer examNo) {
		this.examNo = examNo;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getExamDesc() {
		return examDesc;
	}

	public void setExamDesc(String examDesc) {
		this.examDesc = examDesc;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public String getInputInfo() {
		return inputInfo;
	}

	public void setInputInfo(String inputInfo) {
		this.inputInfo = inputInfo;
	}

	public String getOutputInfo() {
		return outputInfo;
	}

	public void setOutputInfo(String outputInfo) {
		this.outputInfo = outputInfo;
	}

	public String getInputDemo() {
		return inputDemo;
	}

	public void setInputDemo(String inputDemo) {
		this.inputDemo = inputDemo;
	}

	public String getOutputDemo() {
		return outputDemo;
	}

	public void setOutputDemo(String outputDemo) {
		this.outputDemo = outputDemo;
	}

	public String getExamSource() {
		return examSource;
	}

	public void setExamSource(String examSource) {
		this.examSource = examSource;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getValidStatus() {
		return validStatus;
	}

	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

	public String getReverse1() {
		return reverse1;
	}

	public void setReverse1(String reverse1) {
		this.reverse1 = reverse1;
	}

	public String getReverse2() {
		return reverse2;
	}

	public void setReverse2(String reverse2) {
		this.reverse2 = reverse2;
	}

	public String getReverse3() {
		return reverse3;
	}

	public void setReverse3(String reverse3) {
		this.reverse3 = reverse3;
	}

	@Override
	public String toString() {
		return "ExamQuestionInfo [serialNo=" + serialNo + ", examNo=" + examNo + ", examName=" + examName
				+ ", examDesc=" + examDesc + ", examType=" + examType + ", inputInfo=" + inputInfo + ", outputInfo="
				+ outputInfo + ", inputDemo=" + inputDemo + ", outputDemo=" + outputDemo + ", examSource=" + examSource
				+ ", createUser=" + createUser + ", createTime=" + createTime + ", validStatus=" + validStatus
				+ ", reverse1=" + reverse1 + ", reverse2=" + reverse2 + ", reverse3=" + reverse3 + "]";
	}

}