package com.capg.hcs.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.capg.hcs.admin.entity.Admin;
import com.capg.hcs.admin.exception.AdminNotFoundException;
import com.capg.hcs.admin.repository.IAdminRepository;

@Service
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	private IAdminRepository adminRepository;

	/*
	  * This is a GetMethod(Http) is used to check the authorization of Name and Password from Database.
	  * Method 	  : loginAdmin
	  * Type 	  : Admin type
	  * parameters: the adminName and adminPassword is of String type
	  * Returns   : the object of Admin
	  * Author 	  : Alok Dixit
	  * Date 	  : 20/04/2020
	  * Version   : 1.0
	  */
	@Override
	public Admin loginAdmin(String adminName, String adminPassword){
		Admin admin = adminRepository.findAdminByAdminName(adminName);
		if (!(admin.getAdminPassword().equals(adminPassword)
				&& admin.getAdminName().equals(adminName)))
			throw new AdminNotFoundException(
					"Admin with AdminName [" + adminName + "] and password [" + adminPassword + "] not found");
		return admin;
	}


	
	/*
	  * This is a GetMethod(Http) used to get the Admin Details using Admin Id from Database.
	  * Method 	  : getAdmin
	  * Type 	  : Admin
	  * parameters: the adminId is of String type
	  * Returns   : the object of Admin
	  * Author 	  : Alok Dixit
	  * Date 	  : 20/04/2020
	  * Version   : 1.0
	  */
	@Override
	public Admin getAdmin(String adminId) {
		if(!adminRepository.existsById(adminId))
			throw new AdminNotFoundException("User with id "+adminId+" Not Found");
		return adminRepository.getOne(adminId);
	}
}
