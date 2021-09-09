package hrmsfullBackend.hrms.entities.dtos.updateDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialMediaUpdateDto {
	private int id;
    private int CVId;
    private String githubUrl;
    private String linkedinUrl;

}
