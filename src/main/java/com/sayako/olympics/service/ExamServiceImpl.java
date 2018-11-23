package com.sayako.olympics.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sayako.olympics.dao.ExamMapper;
import com.sayako.olympics.entity.ExamSearchDTO;
import com.sayako.olympics.pojo.ExamQuestionInfo;
import com.sayako.olympics.utils.DateUtil;
import com.sayako.olympics.utils.PageDataResult;

@Service
public class ExamServiceImpl implements ExamService {
//	private static final Logger logger = LoggerFactory.getLogger(ExamServiceImpl.class);
	@Autowired
	private ExamMapper examMapper;


	@Override
	public PageDataResult getExams(ExamSearchDTO examSearch, int page, int limit) {
		// 时间处理
		if (null != examSearch) {
			if (StringUtils.isNotEmpty(examSearch.getInsertTimeStart())
					&& StringUtils.isEmpty(examSearch.getInsertTimeEnd())) {
				examSearch.setInsertTimeEnd(DateUtil.format(new Date()));
			} else if (StringUtils.isEmpty(examSearch.getInsertTimeStart())
					&& StringUtils.isNotEmpty(examSearch.getInsertTimeEnd())) {
				examSearch.setInsertTimeStart(DateUtil.format(new Date()));
			}
			if (StringUtils.isNotEmpty(examSearch.getInsertTimeStart())
					&& StringUtils.isNotEmpty(examSearch.getInsertTimeEnd())) {
				if (examSearch.getInsertTimeEnd().compareTo(
						examSearch.getInsertTimeStart()) < 0) {
					String temp = examSearch.getInsertTimeStart();
					examSearch
							.setInsertTimeStart(examSearch.getInsertTimeEnd());
					examSearch.setInsertTimeEnd(temp);
				}
			}
		}
		PageDataResult pdr = new PageDataResult();
		PageHelper.startPage(page, limit);
		List<ExamQuestionInfo> examList = examMapper.getExams(examSearch);
		// 获取分页查询后的数据
		PageInfo<ExamQuestionInfo> pageInfo = new PageInfo<>(examList);
		// 设置获取到的总记录数total：
		pdr.setTotals(Long.valueOf(pageInfo.getTotal()).intValue());
		pdr.setList(examList);
		return pdr;
	}

}
