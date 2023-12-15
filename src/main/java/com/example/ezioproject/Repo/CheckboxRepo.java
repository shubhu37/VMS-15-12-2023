package com.example.ezioproject.Repo;

import java.util.List;

import javax.transaction.Status;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ezioproject.Model.Checkbox;

@Repository
public interface CheckboxRepo extends JpaRepository<Checkbox, Long> {

	public Checkbox findByVisitorId(Long visitorId);

	public List<Checkbox> findByStatus(String string);

	@Query(value = "SELECT visitor_id FROM  `visitor-managment-system`.checkdata where status='true'", nativeQuery = true)
	public List<Long> findVisitorIdByStatus(String status);

	
	
	/*
	 * @Transactional
	 * 
	 * @Modifying
	 * 
	 * @Query(value = "TRUNCATE TABLE checkdata", nativeQuery = true) public void
	 * truncateMeetRow();
	 */
	        @Transactional
            @Modifying
		    @Query(value = "TRUNCATE TABLE checkdata", nativeQuery = true)
		    public void truncateCheckData();
	
}
