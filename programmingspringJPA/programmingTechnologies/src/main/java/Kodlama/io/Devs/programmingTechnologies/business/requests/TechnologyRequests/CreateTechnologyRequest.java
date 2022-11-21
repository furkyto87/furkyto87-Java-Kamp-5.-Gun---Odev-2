package Kodlama.io.Devs.programmingTechnologies.business.requests.TechnologyRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTechnologyRequest {
	private int languageId;
	private String technologyName;
	
}
