package ma.enset.ebankingbackend.repositories;

import ma.enset.ebankingbackend.entities.AccountOperation;
import ma.enset.ebankingbackend.entities.BankAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
    //@Query("select b from AccountOperation b where b.bankAccount.id = :x ")
   // List<AccountOperation> chercherOperationsCompte(@Param("x") String id);
    List<AccountOperation> findByBankAccountId(String accountId);
    Page<AccountOperation> findByBankAccountId(String accountId, Pageable pageable);
}
