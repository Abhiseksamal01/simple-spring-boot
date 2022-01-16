/**
 * Add database methods to the "User" entity. Note that in SQL queries the table name must match
 * the Java class name i.e. "User" not "main.users"
 * 
 * created by Sean Maxwell, 1/15/2022
 */

package com.example.firstmvn.repositories;

import javax.transaction.Transactional;

import com.example.firstmvn.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface IUserRepo extends JpaRepository<User, Long> {
    

    /**
     * Update one user.
     * 
     * @param id
     * @param email
     * @param name
     * @param pwdHash
     */
    @Modifying
    @Query(
        "UPDATE User AS a " + 
        "SET a.email = :email, " +
            "a.name = :name, " +
            "a.pwdHash = :pwdHash " +
        "WHERE a.id = :id"
    )
    public void updateOne(
        @Param("id") Long id,
        @Param("email") String email,
        @Param("name") String name,
        @Param("pwdHash") String pwdHash
    );
}
