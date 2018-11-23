package com.sayako.olympics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sayako.olympics.entity.ExamSearchDTO;
import com.sayako.olympics.pojo.ExamQuestionInfo;

@Mapper
public interface ExamMapper {

	/**
	 * 分页查询数据
	 * @return
	 */
	List<ExamQuestionInfo> getExams(@Param("examSearch") ExamSearchDTO examSearch);

}