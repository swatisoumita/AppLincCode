/**

 *

 */

package application.linc.user;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;



/**

 * @author 258297

 *

 */


@Service
public class UserService {             

	@Autowired
	UserDao userDao;
	
	/*
	 * public LoginResponse logonUser(LoginRequest request) {
	 * 
	 * 
	 * return userDao.getUser(request);
	 * 
	 * } public UserRegistrationResponse registerUser(UserRegistrationRequest
	 * request) {
	 * 
	 * 
	 * 
	 * return userDao.registerUser(request);
	 * 
	 * }
	 */
	
	

	public String logonUser(String request)
	{

				
		return userDao.getUser(request);

	}
	public String registerUser(String request)
	{

		
		
		return userDao.registerUser(request);

	}



}
