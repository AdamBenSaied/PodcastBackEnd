package com.example.demo.repository;

import com.example.demo.model.VO.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserVO,Long> {

  UserVO findUserVOById (Long userId);

  Optional<UserVO> findByMail(String email);


}
