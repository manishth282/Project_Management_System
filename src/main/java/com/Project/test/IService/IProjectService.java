package com.Project.test.IService;

import com.Project.test.Payload.ProjectDto;

import java.util.List;

public interface IProjectService {
    public ProjectDto createProject(ProjectDto projectDto);

    List<ProjectDto> getAllProject();
}
