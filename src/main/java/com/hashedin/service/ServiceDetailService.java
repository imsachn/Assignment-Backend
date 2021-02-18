
package com.hashedin.service;


import com.hashedin.model.Deployment;
import com.hashedin.model.Service;
import com.hashedin.repository.DeploymentRepo;
import com.hashedin.repository.ServiceRepo;
import com.hashedin.web.APIResponseModel;
import com.hashedin.web.model.ServiceWM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceDetailService {

	@Autowired
	private ServiceRepo serviceRepo;

	@Autowired
	private DeploymentRepo deploymentRepo;


	public APIResponseModel updateService( ServiceWM serviceWM) {
		APIResponseModel apiResponseModel = new APIResponseModel();
		if(serviceWM!=null && serviceWM.getId()!=null){
		Optional<Service> service=serviceRepo.findById(serviceWM.getId());
			Optional<Deployment> deploy=deploymentRepo.findByServiceIdAndEnvironment(serviceWM.getId(),serviceWM.getEnv());
		if(service.isPresent() ){
			if(!deploy.isPresent()){

				Deployment deployment = new Deployment();
				deployment.setVersion(serviceWM.getVersion());
				deployment.setEnvironment(serviceWM.getEnv());
				deployment.setUsername(serviceWM.getUsername());
				deployment.setGitbranch(serviceWM.getGitbrach());
				deployment.setTechnology(serviceWM.getTechnology());
				deployment.setService(service.get());
				deploymentRepo.save(deployment);
				apiResponseModel.setMessage("Service updated");
			}
			else{
				update(deploy.get(),serviceWM);
			}
		}
		else {
			Service s = new Service();
			s.setServiceName(serviceWM.getServiceName());
			Deployment deployment = new Deployment();
			deployment.setVersion(serviceWM.getVersion());
			deployment.setEnvironment(serviceWM.getEnv());
			deployment.setUsername(serviceWM.getUsername());
			deployment.setGitbranch(serviceWM.getGitbrach());
			deployment.setTechnology(serviceWM.getTechnology());
			deployment.setService(s);
			deploymentRepo.save(deployment);

		}
		}
		apiResponseModel.setSuccess(true);

		return apiResponseModel;

	}
	public APIResponseModel getService() {
		APIResponseModel apiResponseModel = new APIResponseModel();
		List<Service> serviceList=serviceRepo.findAll(orderBy());
		apiResponseModel.setBody(serviceList);
		apiResponseModel.setSuccess(true);

		return apiResponseModel;
	}

	private Sort orderBy() {
		return new Sort(Sort.Direction.ASC, "serviceName");
	}



	void update(Deployment deployment,ServiceWM serviceWM){
		deployment.setVersion(serviceWM.getVersion());
		deployment.setEnvironment(serviceWM.getEnv());
		deployment.setGitbranch(serviceWM.getGitbrach());
		deployment.setTechnology(serviceWM.getTechnology());
		deployment.setUsername(serviceWM.getUsername());
		deploymentRepo.save(deployment);

	}

	public List<Deployment> getHistoryByEnv(Integer serviceId, String environment) {
		if(environment!=null && !environment.isEmpty()) {
			return deploymentRepo.findAllByServiceIdAndEnvironment(serviceId, environment);
		}
		else
			return deploymentRepo.findAllByServiceId(serviceId);
	}
}
