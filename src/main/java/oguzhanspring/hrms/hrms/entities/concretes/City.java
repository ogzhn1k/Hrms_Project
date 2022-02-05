package oguzhanspring.hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Entity
@Table(name="cities")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class City {
	
	@Id
	@Column(name="city_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cityId;
	
	@Column(name = "city_name")
	@NotBlank
	@NotNull
	private String cityName;
	
	@Column(name = "country")
	@NotBlank
	@NotNull
	private String country;
	
	@JsonIgnore
	@OneToMany(mappedBy = "city",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<JobAdvertisement> jobAdvertisements;
}
