package oguzhanspring.hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "resumes")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","schools","jobExperiences","languages","githubAdresses","linkedinAdresses","abilities"})
public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resume_id")
	private int resumeId;
	
	@Column(name = "cover_letter")
	private String coverLetter;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Seeker seeker;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<School> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<JobExperience> jobExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Language> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<GithubAdress> githubAdresses;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<LinkedinAdress> linkedinAdresses;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Ability> abilities;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Photo> photos;
}
