package hrmsfullBackend.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers", uniqueConstraints = {@UniqueConstraint(columnNames = {"company_name"})})
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Employer extends User {

	@Column(name="company_name")
	@NotNull
	private String companyName;
	
	@Column(name="website")
	@NotNull
	private String website;
	
	@Column(name="phone_number")
	@NotNull
	private String phoneNumber;
	
	@Column(name="picture_url")
	private String pictureUrl="https://www.technopat.net/sosyal/eklenti/02d18dda75a869b005522046f5aa245b-jpg.646363/";
	
	@Column(name="is_update")
	private boolean isUpdate=false;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts;
}
