package com.emc.apiContactos_01.security.repositoy;

import com.emc.apiContactos_01.security.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio que accede a la BBDD
 */
@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByName(String username);
}
