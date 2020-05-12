package com.capg.hcs.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capg.hcs.admin.entity.Admin;
import com.capg.hcs.admin.service.IAdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/healthcaresystem")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
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
	@PostMapping("/admins")
	public Admin loginCustomer(@RequestBody Admin admin) {
		String adminName= admin.getAdminName();
		String adminPassword=admin.getAdminPassword();
		return adminService.loginAdmin(adminName, adminPassword);
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
	@GetMapping("/getAdmin/adminid/{adminId}")
	public ResponseEntity<Admin> getAdmin(@PathVariable String adminId)
	{
		//Calling the service for getting the Admin using ID.
		return new ResponseEntity<Admin>(adminService.getAdmin(adminId),HttpStatus.OK);
	}
}
