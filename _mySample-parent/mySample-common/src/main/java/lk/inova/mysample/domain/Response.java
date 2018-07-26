/**
 * 
 */
package lk.inova.mysample.domain;

/**
 * @author imasmohamed
 * @Description universal response pojo class which should be extended by all other api relavant pojo classes.common properties of response json can be defined here
 */
public class Response {

	
	protected Integer responseCode;
	protected String responseMessage;
	public Integer getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
}
