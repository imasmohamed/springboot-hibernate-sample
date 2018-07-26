/**
 * 
 */
package lk.inova.mysample.domain;

/**
 * @author imasmohamed
 * @Description app user related request json mapping class .
 */
public class AppUserRequest extends Request {
private String userName;

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}
}
