package sendquick.remittance.limit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sendquick.remittance.limit.entity.AccountLimitEntity;

/***
 * @author narayana
 */
@Repository
public interface AccountLimitRepo extends JpaRepository<AccountLimitEntity, String> {

}
