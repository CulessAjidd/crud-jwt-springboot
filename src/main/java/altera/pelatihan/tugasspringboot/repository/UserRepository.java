package altera.pelatihan.tugasspringboot.repository;

import altera.pelatihan.tugasspringboot.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {

    UserModel findByUsername(String username);
}
