
package com.hashedin.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hashedin.model.Service;

import java.util.Optional;


@Repository
public interface ServiceRepo extends JpaRepository<Service, Integer> {


}
