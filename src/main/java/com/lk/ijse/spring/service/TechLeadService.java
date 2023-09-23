package com.lk.ijse.spring.service;

import com.lk.ijse.spring.dto.TechLeadDTO;

import java.util.List;

public interface TechLeadService {
    TechLeadDTO saveTechLead(TechLeadDTO techLeadDTO);

    TechLeadDTO updateTechLead(TechLeadDTO techLeadDTO);

    void deleteTechLeadByPk(String pk);

    List<TechLeadDTO> getAllTechLead();

    TechLeadDTO searchTechLeadByPk(String id);
}
