package com.Project.test.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="Proect")
public class Project {
    @Id
    public String projectID;
    public String projectName;
    public String startDate;
    public String endDate;
    public String projectType;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    public Manager manager;

    public void setProjectID(String projectID) {
        this.projectID=projectID;
    }
}
