package com.data.autogader.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.autogader.entity.Course;
import com.data.autogader.entity.Module;
import com.data.autogader.model.ModuleReqInfo;
import com.data.autogader.repository.ModuleRepository;
import com.data.autogader.service.ModuleService;
@Service
public class ModuleServiceImpl implements ModuleService{

	@Autowired
	ModuleRepository moduleRepository; 
	@Override
	public void save(ModuleReqInfo moduleReqInfo) {

		Module module=new Module();
		module.setName(moduleReqInfo.getName());
		module.setCoordinator(moduleReqInfo.getCoordinator());
		module.setDescription(moduleReqInfo.getDescription());
		moduleRepository.save(module);
	}
	@Override
	public void update(ModuleReqInfo moduleReqInfo,Long id) {
		Optional<Module> moduleRepo = moduleRepository.findById(id);
		if (moduleRepo.isPresent()) {
		
			Module module=new Module();
			module.setId(id);
			module.setName(moduleReqInfo.getName());
			module.setCoordinator(moduleReqInfo.getCoordinator());
			module.setDescription(moduleReqInfo.getDescription());
			moduleRepository.save(module);
			}
		
	}
	@Override
	public void delete(Long id) {
		Optional<Module> module = moduleRepository.findById(id);
		if (module.isPresent()) {
			moduleRepository.deleteById(id);
		}

	}
	}


