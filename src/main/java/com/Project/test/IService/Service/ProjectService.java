package com.Project.test.IService.Service;

import com.Project.test.Exception.ProjectCreationException;
import com.Project.test.Payload.ProjectDto;
import com.Project.test.Repository.ProjectRepository;
import com.Project.test.IService.IProjectService;
import com.Project.test.entity.Project;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProjectService implements IProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper mapper;
    private static final Logger logger = LoggerFactory.getLogger(ProjectService.class);

    public ProjectService(ProjectRepository projectRepository, ModelMapper mapper) {
        this.projectRepository = projectRepository;
        this.mapper = mapper;
    }

    @Override
    public ProjectDto createProject(ProjectDto projectDto) {

            String projectID = UUID.randomUUID().toString();
            Project project = convertToEntity(projectDto);
            project.setProjectID(projectID);

            logger.info("Creating new Project with ID: {}, Details: {}", projectID, projectDto);

            Project savedProject = projectRepository.save(project);
            if (savedProject == null) {
                logger.error("Failed to save project with ID: {}", projectID);
                throw new ProjectCreationException("Failed to save project with ID:" + projectID);
            }
//            logger.info("Successfully saved Project with ID: {}", savedProject.getProjectID());

            return convertToDto(savedProject);
        }

    @Override
    public List<ProjectDto> getAllProject() {
        logger.info("Fetching all projects from the database.");

        List<Project> projectList = projectRepository.findAll();

        logger.info("Retrieved {} projects.", projectList.size());

        return projectList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ProjectDto convertToDto(Project project) {
        logger.debug("Mapping Project entity to ProjectDto: {}", project);
        return mapper.map(project, ProjectDto.class);
    }

    private Project convertToEntity(ProjectDto projectDto) {
        logger.debug("Mapping ProjectDto to Project entity: {}", projectDto);
        return mapper.map(projectDto, Project.class);
    }
}
