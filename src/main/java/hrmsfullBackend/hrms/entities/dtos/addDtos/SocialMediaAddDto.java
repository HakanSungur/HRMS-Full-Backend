package hrmsfullBackend.hrms.entities.dtos.addDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialMediaAddDto {
	
	private int id;
    private int cVId;
    private String githubUrl;
    private String linkedinUrl;

}
