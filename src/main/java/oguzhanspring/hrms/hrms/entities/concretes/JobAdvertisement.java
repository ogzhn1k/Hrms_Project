package oguzhanspring.hrms.hrms.entities.concretes;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jobAdvertisement")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class JobAdvertisement {
	
	@Id
	@Column(name = "advertisement_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int advertisementId;
	
	@Column(name = "job_description")
	@NotBlank
	@NotNull
	private String jobDescription;
	
	@Column(name = "open_positionNumber")
	@NotBlank
	@NotNull
	private int openPositionNumber;
	
	@Column(name = "last_application")
	@NotBlank
	@NotNull
	private Date lastApplication;
	
	@Column(name = "min_salary")
	@NotBlank
	@NotNull
	private int minSalary;
	
	@Column(name = "max_salary")
	@NotBlank
	@NotNull
	private int maxSalary;
	
	@Column(name = "is_active")
	@NotBlank
	@NotNull
	private boolean isActive;
	
	@Column(name = "broad_date")
	@NotBlank
	@NotNull
	private LocalDateTime broadDate = LocalDateTime.now();
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "job_id")
	@JsonIgnore
	private Job job;
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private Employer employer;

}
