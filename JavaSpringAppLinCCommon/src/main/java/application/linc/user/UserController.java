/**

 *

 */

package application.linc.user;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**

 * @author 258297

 *

 */

@RestController
@RequestMapping("/user")

public class UserController {

	@Autowired
	UserService userservice;
	
	/*
	 * @PostMapping("/login") public LoginResponse logonUser(LoginRequest request) {
	 * return userservice.logonUser(request);
	 * 
	 * }
	 * 
	 * @PostMapping("/registration") public UserRegistrationResponse
	 * registerUser(@RequestBody UserRegistrationRequest request) {
	 * 
	 * 
	 * return userservice.registerUser(request); }
	 */
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String logonUser(@RequestBody String request)
	{
		return userservice.logonUser(request);
		
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String registerUser(@RequestBody String request)
	{

		
		return userservice.registerUser(request);
	}



}
