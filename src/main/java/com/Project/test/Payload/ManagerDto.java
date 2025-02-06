package com.Project.test.Payload;

import com.Project.test.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerDto {
    public Long managerId;
    public String managerName;
    public List<Project> projects;
}
