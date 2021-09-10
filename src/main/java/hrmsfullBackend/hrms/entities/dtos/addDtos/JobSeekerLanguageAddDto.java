package hrmsfullBackend.hrms.entities.dtos.addDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerLanguageAddDto {
	
	private int id;
    private int cVId;
    private int languageId;
    private int languageDegree;

}
