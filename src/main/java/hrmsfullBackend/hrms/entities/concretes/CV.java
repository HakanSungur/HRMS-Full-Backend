package hrmsfullBackend.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cvs")
@AllArgsConstructor
@NoArgsConstructor
public class CV {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@Column(name="picture_url")
	private String pictureUrl;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="jobseeker_id")
	private JobSeeker jobSkeer;
	
	@OneToOne(mappedBy = "cV",cascade = CascadeType.DETACH)
	private SocialMedia socialMedia;
	
	@OneToMany(mappedBy = "cV",cascade = CascadeType.DETACH)
	private List<Education> educations;
	
	@OneToMany(mappedBy = "cV",cascade = CascadeType.DETACH)
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy = "cV",cascade = CascadeType.DETACH)
	private List<JobSeekerLanguage> jobSeekerLanguages;
	
	@OneToMany(mappedBy = "cV",cascade = CascadeType.DETACH)
	private List<Technology> technologies;
}
