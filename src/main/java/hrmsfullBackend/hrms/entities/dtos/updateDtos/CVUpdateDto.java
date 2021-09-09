package hrmsfullBackend.hrms.entities.dtos.updateDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVUpdateDto {
	private int id;
	private int jobSkeerId;
	private String pictureUrl;
	private String coverLetter;

}
