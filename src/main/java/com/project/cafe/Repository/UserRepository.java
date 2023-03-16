package com.project.cafe.Repository;

import com.project.cafe.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmailId(@Param("email") String email);
}
