package com.capg.hcs.admin.service;

import com.capg.hcs.admin.entity.Admin;

public interface IAdminService {
	
	Admin loginAdmin(String adminName,String adminPassword);
	Admin getAdmin(String adminId);
}
