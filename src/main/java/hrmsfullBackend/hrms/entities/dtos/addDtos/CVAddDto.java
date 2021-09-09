package hrmsfullBackend.hrms.entities.dtos.addDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVAddDto {

	private int id;
	private int jobSeekerId;
	private String pictureUrl;
	private String coverLetter="";
}
