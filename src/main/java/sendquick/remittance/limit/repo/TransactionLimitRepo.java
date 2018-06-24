package sendquick.remittance.limit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import sendquick.remittance.limit.entity.TransactionLimitEntity;

/***
 *
 * @author narayana
 */
@Repository
public interface TransactionLimitRepo extends JpaRepository<TransactionLimitEntity, Long> {

    TransactionLimitEntity findFirstByCustomerIdAndPayeeIdOrderByCreatedDateDesc(String customerId, String payeeId);
}
