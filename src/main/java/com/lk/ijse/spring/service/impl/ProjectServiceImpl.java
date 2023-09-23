package com.lk.ijse.spring.service.impl;

import com.lk.ijse.spring.dto.ProjectDTO;
import com.lk.ijse.spring.entity.Project;
import com.lk.ijse.spring.exception.NotFoundException;
import com.lk.ijse.spring.repository.ProjectRepository;
import com.lk.ijse.spring.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProjectDTO saveProject(ProjectDTO projectDTO) {

        return modelMapper.map(projectRepository.save(modelMapper.map(projectDTO, Project.class)), ProjectDTO.class);
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO projectDTO) {

        if (!projectRepository.existsById(Integer.valueOf(projectDTO.getProjectId())))
            throw new NotFoundException(projectDTO.getProjectId() + " Project id doesn't exist !");

        return modelMapper.map(projectRepository.save(modelMapper.map(projectDTO, Project.class)), ProjectDTO.class);
    }

    @Override
    public void deleteProjectByPk(int pk) {

        if (!projectRepository.existsById(Integer.valueOf(pk)))
            throw new NotFoundException(pk + " Project id doesn't exist !");

        projectRepository.deleteById(Integer.valueOf(pk));
    }

    @Override
    public List<ProjectDTO> getAllProjects() {

        return modelMapper.map(projectRepository.findAll(), new TypeToken<List<ProjectDTO>>(){}.getType());
    }

    @Override
    public ProjectDTO searchProjectByPk(int pk) {

        if (!projectRepository.existsById(Integer.valueOf(pk)))
            throw new NotFoundException(pk + " Project id doesn't exist !");

        return modelMapper.map(projectRepository.findById(Integer.valueOf(pk)).get(), ProjectDTO.class);
    }
}
