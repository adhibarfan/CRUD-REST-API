/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arfan.adhib.configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author emerio
 */
@EnableScheduling
@Component
public class ScheduledTaskConfiguration {

    @Autowired
    private DataSource dataSource;

    private Connection connection;

    private PreparedStatement preparedStatementSelectUser;
    private PreparedStatement preparedStatementSelectUserRole;

    private PreparedStatement preparedStatementInsertUser;
    private PreparedStatement preparedStatementInsertUserRole;

    private final String selectTableUserSQL = "SELECT * FROM tb_user WHERE username = ?";
    private final String selectTableUserRoleSQL = "SELECT * FROM tb_user_role WHERE username = ?";

    private final String insertTableUserSQL = "INSERT INTO tb_user(username, password, enable) values(?, ?, ?)";
    private final String insertTableUserRoleSQL = "INSERT INTO tb_user_role(id_user_role, role, username) values(?, ?, ?)";

    @Scheduled(fixedRate = 3600000)
    public void insertDefaultUserAdministrator() throws SQLException {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        connection = dataSource.getConnection();

        preparedStatementSelectUser = connection.prepareStatement(selectTableUserSQL);
        preparedStatementSelectUser.setString(1, "user");
        ResultSet resultSetUser = preparedStatementSelectUser.executeQuery();

        preparedStatementSelectUserRole = connection.prepareStatement(selectTableUserRoleSQL);
        preparedStatementSelectUserRole.setString(1, "user");
        ResultSet resultSetUserRole = preparedStatementSelectUserRole.executeQuery();

        if (!resultSetUser.next() && !resultSetUserRole.next()) {
            preparedStatementInsertUser = connection.prepareStatement(insertTableUserSQL);
            preparedStatementInsertUser.setString(1, "user");
            preparedStatementInsertUser.setString(2, bCryptPasswordEncoder.encode("passwordUser"));
            preparedStatementInsertUser.setBoolean(3, Boolean.TRUE);
            preparedStatementInsertUser.executeUpdate();

            preparedStatementInsertUserRole = connection.prepareStatement(insertTableUserRoleSQL);
            preparedStatementInsertUserRole.setString(1, UUID.randomUUID().toString());
            preparedStatementInsertUserRole.setString(2, "ROLE_USER");
            preparedStatementInsertUserRole.setString(3, "user");
            preparedStatementInsertUserRole.executeUpdate();

            preparedStatementInsertUser.close();
            preparedStatementInsertUserRole.close();
        }

        preparedStatementSelectUser.close();
        preparedStatementSelectUserRole.close();
        connection.close();

    }
}