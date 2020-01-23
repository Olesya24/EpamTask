package com.epam.task.repositories;

import com.epam.task.DBUtils.DBConnection;
import com.epam.task.models.Advertisement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdvertisementRepository implements AdRepositoryInterface<Advertisement, Long> {

    public Advertisement add(Advertisement object) {

        Advertisement advertisementRepository = new Advertisement(object);

        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(
                    "INSERT INTO advertisement (adID, adTitle, adCategory, adDescription, adPhone, adCreationDate, authorID) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setLong(1, advertisementRepository.getId());
            statement.setString(2, advertisementRepository.getAdTitle());
            statement.setString(3, advertisementRepository.getAdCategory());
            statement.setString(4, advertisementRepository.getAdDescription());
            statement.setString(5, advertisementRepository.getAdPhone());
            statement.setString(6, advertisementRepository.getAdCreationDate());
            statement.setLong(7, advertisementRepository.getAuthorId());
            statement.execute();

            resultSet = statement.getResultSet();
            if (resultSet.next()) {
                advertisementRepository.setId(resultSet.getLong("adID"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(resultSet);
            DBConnection.close(statement);
            DBConnection.close(connection);
        }

        return advertisementRepository;
    }

    @Override
    public boolean removeById(Long id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("DELETE FROM advertisement WHERE adID=(?)");
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

    @Override
    public Advertisement get(Long id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM advertisement WHERE adID=(?)");
            statement.setLong(1, id);
            statement.execute();
            resultSet = statement.getResultSet();

            if (resultSet.next()) {
                Advertisement advertisementRepository = new Advertisement();

                advertisementRepository.setId(resultSet.getLong("adID"));
                advertisementRepository.setAdTitle(resultSet.getString("adTitle"));
                advertisementRepository.setAdCategory(resultSet.getString("adCategory"));
                advertisementRepository.setAdDescription(resultSet.getString("adDescription"));
                advertisementRepository.setAdPhone(resultSet.getString("adPhone"));
                advertisementRepository.setAdCreationDate(resultSet.getString("adCreationDate"));
                advertisementRepository.setAuthorId(resultSet.getLong("authorID"));

                return advertisementRepository;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(resultSet);
            DBConnection.close(statement);
            DBConnection.close(connection);
        }
    }

    public List<Advertisement> get() {
        List<Advertisement> advertisements = new ArrayList<>();

        Connection connection = DBConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM advertisement");
            while (resultSet.next()) {
                Advertisement advertisementRepository = new Advertisement();
                advertisementRepository.setId(resultSet.getLong("adID"));
                advertisementRepository.setAdTitle(resultSet.getString("adTitle"));
                advertisementRepository.setAdCategory(resultSet.getString("adCategory"));
                advertisementRepository.setAdDescription(resultSet.getString("adDescription"));
                advertisementRepository.setAdPhone(resultSet.getString("adPhone"));
                advertisementRepository.setAdCreationDate(resultSet.getString("adCreationDate"));
                advertisementRepository.setAuthorId(resultSet.getLong("authorID"));
                advertisements.add(advertisementRepository);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(resultSet);
            DBConnection.close(statement);
            DBConnection.close(connection);
        }

        return advertisements;
    }

    public List<Advertisement> findAllByUserId(Long id) {
        List<Advertisement> advertisements = new ArrayList<>();

        Connection connection = DBConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM advertisement WHERE authorID=" + id);
            while (resultSet.next()) {
                Advertisement advertisementRepository = new Advertisement();
                advertisementRepository.setId(resultSet.getLong("adID"));
                advertisementRepository.setAdTitle(resultSet.getString("adTitle"));
                advertisementRepository.setAdCategory(resultSet.getString("adCategory"));
                advertisementRepository.setAdDescription(resultSet.getString("adDescription"));
                advertisementRepository.setAdPhone(resultSet.getString("adPhone"));
                advertisementRepository.setAdCreationDate(resultSet.getString("adCreationDate"));
                advertisementRepository.setAuthorId(resultSet.getLong("authorID"));
                advertisements.add(advertisementRepository);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(resultSet);
            DBConnection.close(statement);
            DBConnection.close(connection);
        }

        return advertisements;
    }
}
