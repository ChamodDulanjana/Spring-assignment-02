package com.lk.ijse.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ProjectDTO {
    private int projectId;
    private String projectName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private TechLeadDTO techLead;
}
