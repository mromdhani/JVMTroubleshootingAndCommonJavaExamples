package be.bt.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.bt.security.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
