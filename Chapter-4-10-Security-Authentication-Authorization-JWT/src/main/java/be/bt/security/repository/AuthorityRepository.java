package be.bt.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.bt.security.domain.Authority;



public interface AuthorityRepository extends JpaRepository<Authority, Long> {
  
}
