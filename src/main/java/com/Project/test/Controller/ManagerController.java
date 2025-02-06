package com.Project.test.Controller;

import com.Project.test.IService.IManagerService;
import com.Project.test.Payload.ManagerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {
    private final IManagerService iManagerService;

    public ManagerController(IManagerService iManagerService) {
        this.iManagerService = iManagerService;
    }
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ManagerDto> addManager(@RequestBody ManagerDto managerdto){
ManagerDto managerDto=iManagerService.addManager(managerdto);
if(managerDto==null){
    return new ResponseEntity<>(managerDto, HttpStatus.BAD_REQUEST);
}
return new ResponseEntity<>(managerDto,HttpStatus.CREATED);
    }
}
