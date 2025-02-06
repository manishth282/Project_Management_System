package com.Project.test.IService.Service;

import com.Project.test.IService.IManagerService;
import com.Project.test.Payload.ManagerDto;
import com.Project.test.Repository.ManagerRepository;
import com.Project.test.entity.Manager;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ManagerService implements IManagerService {
    private final ManagerRepository managerRepository;
    private final ModelMapper mapper;

    public ManagerService(ManagerRepository managerRepository, ModelMapper mapper) {
        this.managerRepository = managerRepository;
        this.mapper = mapper;
    }

    @Override
    public ManagerDto addManager(ManagerDto managerDto) {
        Manager manager=mapper.map(managerDto,Manager.class);
        Manager savedManager=managerRepository.save(manager);
        return mapper.map(savedManager,ManagerDto.class);
    }
}
