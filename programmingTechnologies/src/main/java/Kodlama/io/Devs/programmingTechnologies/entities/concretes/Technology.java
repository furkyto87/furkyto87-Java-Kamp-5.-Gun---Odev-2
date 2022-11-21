package Kodlama.io.Devs.programmingTechnologies.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "technologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Technology {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "technology_id")
	private int technologyId;
	
	@Column(name = "technology_name")
	private String technologyName;

	
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "language_id", nullable = false) 
	  private Language language;
	 
}
