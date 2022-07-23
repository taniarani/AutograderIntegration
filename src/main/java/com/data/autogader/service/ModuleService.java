package com.data.autogader.service;

import com.data.autogader.model.ModuleReqInfo;

public interface ModuleService {
	public void save(ModuleReqInfo moduleReqInfo);
	public void update(ModuleReqInfo moduleReqInfo,Long id);
	public void delete(Long id);
}
