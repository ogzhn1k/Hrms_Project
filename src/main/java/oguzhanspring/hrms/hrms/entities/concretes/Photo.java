package oguzhanspring.hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// Cloudinary --> Alivelideli1907, 

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "photos")
public class Photo {
	
	@Id
	@GeneratedValue
	@Column(name = "photo_id")
	private int photoId;
	
	@Column(name = "photo_URL")
	private String photoURL;
	
	@ManyToOne
	@JoinColumn(name = "resume_id")
	@JsonIgnore
    private Resume resume;

}
