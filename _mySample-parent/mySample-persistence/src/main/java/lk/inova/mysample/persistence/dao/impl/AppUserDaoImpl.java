/**
 * 
 */
package lk.inova.mysample.persistence.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lk.inova.mysample.common.entities.AppUser;
import lk.inova.mysample.persistence.dao.i.AppUserDao;

/**
 * @author imasmohamed
 *
 */
@Repository
@Transactional
public class AppUserDaoImpl implements AppUserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void save(AppUser appUser) {
		System.out.println(sessionFactory);
		sessionFactory.getCurrentSession().save(appUser);
		
	}

}
