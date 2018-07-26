/**
 * 
 */
package lk.inova.mysample.web.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lk.inova.mysample.core.service.i.AppCoreService;
import lk.inova.mysample.domain.AppUserRequest;
import lk.inova.mysample.domain.AppUserResponse;
import lk.inova.mysample.web.controller.i.AppService;

/**
 * @author imasmohamed
 * @Description implementation logic of app related restful web services
 */
@RestController
@RequestMapping("/mysample/v1.0/services")
public class RestAppService implements AppService {
	@Autowired
	private AppCoreService appCoreServiceImpl;

	@Override
	@GetMapping("/version")
	public String getVersion() {
		return "mysample project -20180725a";
		// FIXME get from property value
	}

	@Override
	@PostMapping("/user")
	public @ResponseBody AppUserResponse addSystemUser(@RequestBody AppUserRequest request) {

		appCoreServiceImpl.addSystemUser(request);
		return new AppUserResponse(1, "User created Successfully");
	}

}
