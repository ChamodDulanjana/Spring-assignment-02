package com.lk.ijse.spring.service;

import com.lk.ijse.spring.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    ProjectDTO saveProject(ProjectDTO projectDTO);

    ProjectDTO updateProject(ProjectDTO projectDTO);

    void deleteProjectByPk(int pk);

    List<ProjectDTO> getAllProjects();

    ProjectDTO searchProjectByPk(int pk);
}
