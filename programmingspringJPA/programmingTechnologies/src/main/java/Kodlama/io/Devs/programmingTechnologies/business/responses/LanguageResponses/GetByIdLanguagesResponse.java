package Kodlama.io.Devs.programmingTechnologies.business.responses.LanguageResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdLanguagesResponse {
	private int languageId;
	private String languageName;
}
