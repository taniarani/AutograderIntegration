package com.data.autogader.service;

import com.data.autogader.model.CourseReqInfo;

public interface CourseService {
	public void save(CourseReqInfo courseReqInf);
	public void update(CourseReqInfo courseReqInf,Long id);
	public void delete(Long id);
}
