package Kodlama.io.Devs.programmingTechnologies.business.responses.TechnologyResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdTechnologiesResponse {
    private int technologyId;
    private String technologyName;
    private int languageId;
	private String languageName;
}
