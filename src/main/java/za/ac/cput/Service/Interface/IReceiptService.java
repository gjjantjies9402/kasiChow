/**IReceiptServices.java
 * Service Interface for Receipt
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 17 October 2022
 **/
package za.ac.cput.Service.Interface;

import za.ac.cput.Entity.Receipt;
import za.ac.cput.Service.IService;
import java.util.Set;

public interface IReceiptService extends IService<Receipt, String> {
    Set<Receipt> getAll();
}
