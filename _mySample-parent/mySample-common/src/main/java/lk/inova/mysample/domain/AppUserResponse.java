
package lk.inova.mysample.domain;


/**
 * @author imasmohamed
 * @Description pojo mapping class for response of  appuser functions 
 */

public class AppUserResponse extends Response {

	public AppUserResponse(int responseCode, String responseMessage) {
		super.responseCode=responseCode;
		super.responseMessage=responseMessage;
	}

}
