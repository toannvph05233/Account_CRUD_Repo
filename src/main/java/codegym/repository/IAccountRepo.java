package codegym.repository;

import codegym.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface IAccountRepo extends CrudRepository<Account, Long> {

    @Query(value = "SELECT * FROM CrudAccount.Account where userName like concat('%',:name,'%')", nativeQuery = true)
    public ArrayList<Account> findAllByName(@Param("name") String userName);

    @Query(value = "SELECT a FROM Account as a where a.userName like concat('%',:name,'%')")
    public ArrayList<Account> findAllByName2(@Param("name") String userName);
}
