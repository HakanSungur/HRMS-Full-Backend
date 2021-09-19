package hrmsfullBackend.hrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="favorites")
@AllArgsConstructor
@NoArgsConstructor
public class Favorite {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="jobseeker_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="jobseeker_id")
	private JobAdvert jobAdvert;
}
