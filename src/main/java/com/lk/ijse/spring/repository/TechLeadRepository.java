package com.lk.ijse.spring.repository;

import com.lk.ijse.spring.entity.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechLeadRepository extends JpaRepository<TechLead, String> {
}
