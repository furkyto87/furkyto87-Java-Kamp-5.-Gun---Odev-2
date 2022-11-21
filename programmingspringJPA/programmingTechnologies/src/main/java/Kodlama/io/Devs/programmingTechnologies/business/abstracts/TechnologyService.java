package Kodlama.io.Devs.programmingTechnologies.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.programmingTechnologies.business.requests.TechnologyRequests.CreateTechnologyRequest;
import Kodlama.io.Devs.programmingTechnologies.business.requests.TechnologyRequests.DeleteTechnologyRequest;
import Kodlama.io.Devs.programmingTechnologies.business.requests.TechnologyRequests.UpdateTechnologyRequest;
import Kodlama.io.Devs.programmingTechnologies.business.responses.TechnologyResponses.GetAllTechnologiesResponse;
import Kodlama.io.Devs.programmingTechnologies.business.responses.TechnologyResponses.GetByIdTechnologiesResponse;

public interface TechnologyService {
	
	List<GetAllTechnologiesResponse> getAll();
	
	void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
	
	void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception;

	void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception;

	GetByIdTechnologiesResponse getById(int technology_id) throws Exception;
}
