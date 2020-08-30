package victor.io.projeto1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import victor.io.projeto1.entity.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{'email' : ?0 }")
    User findByEmailLala(String email);

    User findByNameIgnoreCaseLike(String name);

}
