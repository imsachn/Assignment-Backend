package com.hashedin.repository;


import java.util.List;
import java.util.Optional;

import com.hashedin.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hashedin.model.Deployment;


@Repository
public interface DeploymentRepo extends JpaRepository<Deployment, Integer> {
	
	List<Deployment> findAllByService(Service service);
/*

	List<Deployment> findAllByServiceIdAndEnvironment(Integer serviceId, String environment);
*/

	Optional<Deployment> findByServiceIdAndEnvironment(Integer serviceId, String environment);

	List<Deployment> findAllByServiceId(Integer serviceId);

	List<Deployment> findAllByServiceIdAndEnvironment(Integer serviceId,String environment);
}
