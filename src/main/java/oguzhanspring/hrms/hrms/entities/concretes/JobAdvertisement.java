package oguzhanspring.hrms.hrms.entities.concretes;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jobAdvertisements")
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
	private String jobDescription;
	
	@Column(name = "open_positionNumber")
	private int openPositionNumber;
	
	@Column(name = "last_application")
	private Date lastApplication;
	
	@Column(name = "min_salary")
	private int minSalary;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "broad_date")
	private LocalDateTime broadDate = LocalDateTime.now();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "job_id")
	private Job job;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "user_id")
	private Employer employer;

}
