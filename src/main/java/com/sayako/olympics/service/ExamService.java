package com.sayako.olympics.service;

import com.sayako.olympics.entity.ExamSearchDTO;
import com.sayako.olympics.utils.PageDataResult;

public interface ExamService {
	/**
	 * 分页查询试题列表
	 * @param page
	 * @param limit
	 * @return
	 */
	PageDataResult getExams(ExamSearchDTO examSearch, int page, int limit);

}
