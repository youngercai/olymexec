package com.sayako.olympics.entity;

/**
 * @类描述：试题查询条件对象 
 * @创建人： 
 * @创建时间：2018-10-02 17:10 
 * @version：V1.0
 */
public class ExamSearchDTO {

	private Integer page;

	private Integer limit;

	private String examName;

	private String examType;

	private String insertTimeStart;

	private String insertTimeEnd;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public String getInsertTimeStart() {
		return insertTimeStart;
	}

	public void setInsertTimeStart(String insertTimeStart) {
		this.insertTimeStart = insertTimeStart;
	}

	public String getInsertTimeEnd() {
		return insertTimeEnd;
	}

	public void setInsertTimeEnd(String insertTimeEnd) {
		this.insertTimeEnd = insertTimeEnd;
	}

	@Override
	public String toString() {
		return "ExamSearchDTO{" + "page=" + page + ", limit=" + limit + ", examName='" + examName + '\''
				+ ", examType='" + examType + '\'' + ", insertTimeStart='" + insertTimeStart + '\''
				+ ", insertTimeEnd='" + insertTimeEnd + '\'' + '}';
	}
}
