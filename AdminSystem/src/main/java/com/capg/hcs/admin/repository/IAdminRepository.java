package com.capg.hcs.admin.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.capg.hcs.admin.entity.Admin;
public interface IAdminRepository extends JpaRepository<Admin, String>{
	
	public Admin findAdminByAdminName(String adminName);

}
