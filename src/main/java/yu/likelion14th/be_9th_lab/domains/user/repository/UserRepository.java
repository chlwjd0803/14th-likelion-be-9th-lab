package yu.likelion14th.be_9th_lab.domains.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yu.likelion14th.be_9th_lab.domains.user.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
