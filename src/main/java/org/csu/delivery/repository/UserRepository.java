package org.csu.delivery.repository;

import org.csu.delivery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Modifying
    @Query("update User u set u.userName = ?1 where u.userId = ?2")
    int setFixedFirstnameFor(String firstname, String lastname);

    User getUserByUserName(String username);
}
