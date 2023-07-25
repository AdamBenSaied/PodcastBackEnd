package com.example.demo.repository;

import com.example.demo.model.VO.TokenVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<TokenVO,Long> {

            /*------------------------------HAHAHAHAHAHAHAHAHAHAHAAHAHAHAHAHHAAA-------------------------------------------*/
//    @Query(value = " SELECT TOKEN FROM tokens t INNER JOIN users u ON t.ID_USER = :u.ID " +
//            "WHERE :u.ID = t.ID_USER AND (t.EXPIRED = 0 OR t.REVOKED = 0)"
//            , nativeQuery = true)
//    List<TokenVO> findAllValidTokenByUser(@Param("ID") Long id);

    List<TokenVO> findByUser_IdAndRevokedAndExpired(Long id, boolean revoked, boolean expired);


    Optional<TokenVO> findByToken(String token);
}
