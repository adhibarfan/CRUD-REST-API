/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arfan.adhib.repository;

import com.arfan.adhib.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author emerio
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {

    @Query("select u from User u left join fetch u.userRoles pd where u.username = :username")
    User loginUser(@Param("username") String username);

}
