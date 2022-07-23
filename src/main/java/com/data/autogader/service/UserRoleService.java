package com.data.autogader.service;

import com.data.autogader.model.UserRoleRequestInfo;


public interface UserRoleService {
	public void save(UserRoleRequestInfo userRoleRequestInfo);
	public void update(UserRoleRequestInfo userRoleRequestInfo,Long id);
	public void delete(Long id);
}
