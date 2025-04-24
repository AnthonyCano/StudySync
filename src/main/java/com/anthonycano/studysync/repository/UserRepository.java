package com.anthonycano.studysync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anthonycano.studysync.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
