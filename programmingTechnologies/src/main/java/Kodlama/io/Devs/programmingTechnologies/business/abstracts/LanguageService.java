package Kodlama.io.Devs.programmingTechnologies.business.abstracts;


import java.util.List;

import Kodlama.io.Devs.programmingTechnologies.business.requests.LanguageRequests.CreateLanguageRequest;
import Kodlama.io.Devs.programmingTechnologies.business.requests.LanguageRequests.DeleteLanguageRequest;
import Kodlama.io.Devs.programmingTechnologies.business.requests.LanguageRequests.UpdateLanguageRequest;
import Kodlama.io.Devs.programmingTechnologies.business.responses.LanguageResponses.GetAllLanguagesResponse;
import Kodlama.io.Devs.programmingTechnologies.business.responses.LanguageResponses.GetByIdLanguagesResponse;

public interface LanguageService {
	
List<GetAllLanguagesResponse> getAll();

void add(CreateLanguageRequest createLanguageRequest) throws Exception;

void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception;

void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;

GetByIdLanguagesResponse getById(int language_id) throws Exception;

}
