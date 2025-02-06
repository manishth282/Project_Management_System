package com.Project.test.Controller;

import com.Project.test.Payload.ProjectDto;
import com.Project.test.IService.IProjectService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProjectController {
    private final IProjectService iprojectService;
    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
    public ProjectController(IProjectService iprojectService) {
        this.iprojectService = iprojectService;
    }
    @PostMapping("/createProject")
    public ResponseEntity<?> createProject(@RequestBody @Valid  ProjectDto projectDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            List<String> errors = getErrorMessages(bindingResult);
            logger.error(" validation error occurred ProductDto:{} ,error:{}", projectDto, errors);
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        ProjectDto result=iprojectService.createProject(projectDto);
        if (result != null) {
            logger.info("Successfully created a new Project: {}", result);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
     logger.warn("Project creation is failed");
        return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/getAllProject")
    public List<ProjectDto> getAllProject(){
        List<ProjectDto> projectDtos=iprojectService.getAllProject();
        return projectDtos;
    }
    private List<String> getErrorMessages(BindingResult bindingResult) {

        return bindingResult.getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

    }
}
