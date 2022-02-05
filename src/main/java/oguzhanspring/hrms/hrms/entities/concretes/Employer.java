package oguzhanspring.hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Employer extends User{
	
	@Column(name = "company_name")
	@NotBlank
	@NotNull
	private String companyName;
	
	@Column(name = "web_site")
	@NotBlank
	@NotNull
	private String webSite;
	
	@Column(name = "tel_number")
	@NotBlank
	@NotNull
	private String telNumber;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<JobAdvertisement> jobAdvertisements;

}
