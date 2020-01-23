package com.epam.task.repositories;

import com.epam.task.DBUtils.DBConnection;
import com.epam.task.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements UserRepositoryInterface<User, Long> {

    public User add(User object) {

        User userRepository = new User(object);

        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(
                    "INSERT INTO user (userID, userName, userSurname, userEmail, userCategory) " +
                            "VALUES (?, ?, ?, ?, ?)");
            statement.setLong(1, userRepository.getUserId());
            statement.setString(2, userRepository.getUserName());
            statement.setString(3, userRepository.getUserSurname());
            statement.setString(4, userRepository.getUserEmail());
            statement.setString(5, userRepository.getUserCategory());
            statement.execute();

            resultSet = statement.getResultSet();
            if (resultSet.next()) {
                userRepository.setUserId(resultSet.getLong("userID"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(resultSet);
            DBConnection.close(statement);
            DBConnection.close(connection);
        }

        return userRepository;
    }

    @Override

    public boolean removeById(Long id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("DELETE FROM user WHERE userID=(?)");
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(statement);
            DBConnection.close(connection);
        }

        return true;
    }
}
