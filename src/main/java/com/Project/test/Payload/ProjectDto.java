package com.Project.test.Payload;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    public String projectID;
    @NotNull
    public String projectName;
    public String startDate;
    @NotNull
    public String endDate;
    @NotNull
    public String projectType;
    public String managerId;
}
