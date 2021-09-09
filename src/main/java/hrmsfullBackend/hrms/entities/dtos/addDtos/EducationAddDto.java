package hrmsfullBackend.hrms.entities.dtos.addDtos;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationAddDto {

	private int id;
    private int CVId;
    private int schoolId;
    private int departmentId;
    private LocalDate startDate;
    private LocalDate endDate;
}
