/**

*

 */

package application.linc.user;

 

import java.util.ArrayList;

 

/**

* @author 258297

*

*/

public class UserRegistrationRequest {

      

       public String userType;

       public String name;

       public String email;

       public String phone;

       public Address address;

       public String supplierVolType;

       public String serviceList;

       /**

       * @return the userType

       */

       public String getUserType() {

             return userType;

       }

       /**

       * @param userType the userType to set

       */

       public void setUserType(String userType) {

             this.userType = userType;

       }

       /**

       * @return the name

       */

       public String getName() {

             return name;

       }

       /**

       * @param name the name to set

       */

       public void setName(String name) {

             this.name = name;

       }

       /**

       * @return the email

       */

       public String getEmail() {

             return email;

       }

       /**

       * @param email the email to set

       */

       public void setEmail(String email) {

             this.email = email;

       }

       /**

       * @return the phone

       */

       public String getPhone() {

             return phone;

       }

       /**

       * @param phone the phone to set

       */

       public void setPhone(String phone) {

             this.phone = phone;

       }

       /**

       * @return the address

       */

       public Address getAddress() {

             return address;

       }

       /**

       * @param address the address to set

       */

       public void setAddress(Address address) {

             this.address = address;

       }

       /**

       * @return the supplierVolType

       */

       public String getSupplierVolType() {

             return supplierVolType;

       }

       /**

       * @param supplierVolType the supplierVolType to set

       */

       public void setSupplierVolType(String supplierVolType) {

             this.supplierVolType = supplierVolType;

       }

       /**

       * @return the serviceList

       */

       public String getServiceList() {

             return serviceList;

       }

       /**

       * @param serviceList the serviceList to set

       */

       public void setServiceList(String serviceList) {

             this.serviceList = serviceList;

       }

       /* (non-Javadoc)

       * @see java.lang.Object#toString()

       */

       @Override

       public String toString() {

             return "UserRegistrationRequest [userType=" + userType + ", name=" + name + ", email=" + email + ", phone="

                          + phone + ", address=" + address + ", supplierVolType=" + supplierVolType + ", serviceList="

                          + serviceList + "]";

       }

      

      

 

}