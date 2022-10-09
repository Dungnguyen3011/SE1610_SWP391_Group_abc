package com.swp391.ebutler.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.swp391.ebutler.entities.Provider;
import com.swp391.ebutler.entities.ServiceProvider;
import com.swp391.ebutler.entities.Services;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Integer> {

	@Query("SELECT COUNT(*) FROM ServiceProvider s WHERE s.service.serviceId = ?1")
	Integer countByServiceId(int id);
	
	@Query("SELECT COUNT(*) FROM ServiceProvider s WHERE s.provider.providerId = ?1")
	Integer countByProviderId(int id);
	
	List<ServiceProvider> findByStatus(Boolean status);
	
	List<ServiceProvider> findByStatus(Boolean status, Sort sort);
	
	List<ServiceProvider> findByProvider(Provider provider);
	
	List<ServiceProvider> findByProviderAndStatus(Provider provider, Boolean status);
	
	List<ServiceProvider> findByService(Services service);
	
	List<ServiceProvider> findByServiceAndStatus(Services service, Boolean status);
	
	@Query("Select sp "
			+ "from ServiceProvider sp inner join Services s "
			+ "on sp.service.serviceId = s.serviceId "
			+ "inner join ServiceCategory sc "
			+ "on s.sCategory.servicecategoryId = sc.servicecategoryId "
			+ "where sc.servicecategoryId = ?1 ")
	List<ServiceProvider> findByServiceCategoryId(int id);
}
