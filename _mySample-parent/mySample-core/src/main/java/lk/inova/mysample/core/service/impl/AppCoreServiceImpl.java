/**
 * 
 */
package lk.inova.mysample.core.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.inova.mysample.common.entities.AppUser;
import lk.inova.mysample.core.service.i.AppCoreService;
import lk.inova.mysample.domain.AppUserRequest;
import lk.inova.mysample.persistence.dao.i.AppUserDao;

/**
 * @author imasmohamed
 * @Description App functionalities will be implemented in this scope
 */
@Service
public class AppCoreServiceImpl implements AppCoreService {

	@Autowired
	private AppUserDao appUserDaoImpl;
	
	@Override
	public void addSystemUser(AppUserRequest appUserRequest) {

		appUserDaoImpl.save(new AppUser(appUserRequest.getUserName(),new Date()));

	}

}
