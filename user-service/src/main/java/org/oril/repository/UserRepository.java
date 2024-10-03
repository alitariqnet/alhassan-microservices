package org.oril.repository;

import org.oril.entities.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface UserRepository extends JpaRepositoryImplementation<User, Long> {
}
