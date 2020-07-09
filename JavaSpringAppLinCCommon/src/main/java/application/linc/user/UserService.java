/**

*

 */

package application.linc.user;

 

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

 

/**

* @author 258297

*

*/

@RestController

@RequestMapping("/user")

public class UserService {

             

  @PostMapping("/registration")
  public UserRegistrationResponse registerUser(@RequestBody UserRegistrationRequest request)

  {

                 UserRegistrationResponse response = new UserRegistrationResponse();

                 response.setStatus("success");

                 return response;

  }

 

}
