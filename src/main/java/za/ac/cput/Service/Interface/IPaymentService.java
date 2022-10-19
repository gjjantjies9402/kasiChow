/**IPaymentServices.java
 * Service Interface for Payment
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 17 October 2022
 **/
package za.ac.cput.Service.Interface;

import za.ac.cput.Entity.Payment;
import za.ac.cput.Service.IService;
import java.util.Set;

public interface IPaymentService extends IService<Payment, String> {
    Set<Payment> getAll();
}
