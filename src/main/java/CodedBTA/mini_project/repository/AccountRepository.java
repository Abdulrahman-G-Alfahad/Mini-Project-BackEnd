package CodedBTA.mini_project.repository;

import CodedBTA.mini_project.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity,Long> {

    Optional<AccountEntity> findByUserId(Long userId);
}
