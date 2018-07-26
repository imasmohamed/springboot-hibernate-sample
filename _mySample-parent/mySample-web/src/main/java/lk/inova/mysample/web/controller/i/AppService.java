/**
 * 
 */
package lk.inova.mysample.web.controller.i;

import lk.inova.mysample.domain.AppUserRequest;
import lk.inova.mysample.domain.AppUserResponse;

/**
 * @author imasmohamed
 * @Description Application related services are defined in here
 */
public interface AppService {

	public String getVersion();
	public AppUserResponse addSystemUser(AppUserRequest request);
	
	
}
