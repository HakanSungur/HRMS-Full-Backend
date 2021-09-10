package hrmsfullBackend.hrms.entities.dtos.addDtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceAddDto {

	private int id;
    private int cVId;
    private String companyName;
    private String positionName;
    private LocalDate startDate;
    private LocalDate endDate;
}
