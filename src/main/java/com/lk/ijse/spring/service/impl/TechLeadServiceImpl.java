package com.lk.ijse.spring.service.impl;

import com.lk.ijse.spring.dto.TechLeadDTO;
import com.lk.ijse.spring.entity.TechLead;
import com.lk.ijse.spring.exception.NotFoundException;
import com.lk.ijse.spring.repository.TechLeadRepository;
import com.lk.ijse.spring.service.TechLeadService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TechLeadServiceImpl implements TechLeadService {
    @Autowired
    private TechLeadRepository techLeadRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TechLeadDTO saveTechLead(TechLeadDTO techLeadDTO) {

        techLeadDTO.setId(UUID.randomUUID().toString());
        if (techLeadRepository.existsById(techLeadDTO.getId()))
            throw new RuntimeException(techLeadDTO.getId() + " Tech lead id already exist !");

        return modelMapper.map(techLeadRepository.save(modelMapper.map(techLeadDTO, TechLead.class)), TechLeadDTO.class);
    }

    @Override
    public TechLeadDTO updateTechLead(TechLeadDTO techLeadDTO) {

        if (!techLeadRepository.existsById(techLeadDTO.getId()))
            throw new NotFoundException(techLeadDTO.getId() + " Tech lead id doesn't exist !");

        return modelMapper.map(techLeadRepository.save(modelMapper.map(techLeadDTO, TechLead.class)), TechLeadDTO.class);
    }

    @Override
    public void deleteTechLeadByPk(String pk) {

        if (!techLeadRepository.existsById(pk))
            throw new NotFoundException(pk + " Tech lead id doesn't exist !");

        techLeadRepository.deleteById(pk);
    }

    @Override
    public List<TechLeadDTO> getAllTechLead() {

        return modelMapper.map(techLeadRepository.findAll(), new TypeToken<List<TechLeadDTO>>(){}.getType());
    }

    @Override
    public TechLeadDTO searchTechLeadByPk(String pk) {

        if (!techLeadRepository.existsById(pk))
            throw new NotFoundException(pk + " Tech lead id doesn't exist !");

        return modelMapper.map(techLeadRepository.findById(pk).get(), TechLeadDTO.class);
    }
}
