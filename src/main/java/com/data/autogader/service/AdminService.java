package com.data.autogader.service;

import com.data.autogader.model.AdminRequestInfo;

public interface AdminService {

	public void save(AdminRequestInfo adminRequestInfo);

	public void update(AdminRequestInfo adminRequestInfo,Long id);

	public void delete(Long id);
}
