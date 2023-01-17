package org.sid.DAL;

import org.sid.connection.DBConnection;
import org.sid.entities.Freelancer;
import org.sid.repositories.FreelancerRepository;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FreelancerRepositoryImpl implements FreelancerRepository {

    private DBConnection dbConnection;

    @Override
    public void save(Freelancer freelancer) throws IOException, SQLException {
        this.dbConnection = new DBConnection();

        String query = "INSERT INTO freelancer(name,secondName,cin , job) VALUES(?,?,?,?)";
        PreparedStatement statement = this.dbConnection.connect().prepareStatement(query);

        statement.setString(1,freelancer.getName());
        statement.setString(2,freelancer.getSecondName());
        statement.setString(3,freelancer.getCin());
        statement.setString(4,freelancer.getJob());
        statement.executeUpdate();
        statement.close();
        dbConnection.disconnect();
    }

    @Override
    public void update(Freelancer freelancer) throws IOException {
        this.dbConnection = new DBConnection();
        try {
            String query = "UPDATE freelancer SET name= ?  , secondName = ? , cin = ? , job = ?   WHERE id = ?";
            PreparedStatement statement = this.dbConnection.connect().prepareStatement(query);
            statement.setString(1,freelancer.getName());
            statement.setString(2,freelancer.getSecondName());
            statement.setString(3,freelancer.getCin());
            statement.setString(4,freelancer.getJob());
            statement.setInt(5,freelancer.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            dbConnection.disconnect();
        }
    }

    @Override
    public void delete(int id) throws IOException {
        this.dbConnection = new DBConnection();

        String query = "DELETE FROM freelancer WHERE id= ?";

        PreparedStatement statement = null;
        try {
            statement = this.dbConnection.connect().prepareStatement(query);
            statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            dbConnection.disconnect();
        }
    }

    public ArrayList<Freelancer> getAllFreelancers() throws IOException {
        this.dbConnection = new DBConnection();
        try {
            String query = "SELECT * from freelancer";
            PreparedStatement statement = this.dbConnection.connect().prepareStatement(query);
            ResultSet  resultSet = statement.executeQuery();;
            ArrayList<Freelancer> freelancers = new ArrayList<>();
            while(resultSet.next())
            {
                Freelancer freelancer = new Freelancer();
                freelancer.setId(resultSet.getInt(1));
                freelancer.setName(resultSet.getString(2));
                freelancer.setSecondName(resultSet.getString(3));
                freelancer.setCin(resultSet.getString(4));
                freelancer.setJob(resultSet.getString(5));
                freelancers.add(freelancer);
            }
            return freelancers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            this.dbConnection.disconnect();
        }
    }

    @Override
    public Freelancer getFreelancer(String cin) throws IOException {
        try {
            Freelancer freelancer = new Freelancer();
            String query = "Select * from  freelancer  SET   WHERE id = ?";
            PreparedStatement statement = this.dbConnection.connect().prepareStatement(query);
            ResultSet  resultSet = statement.executeQuery();;
            while(resultSet.next())
            {
                freelancer.setId(resultSet.getInt(1));
                freelancer.setName(resultSet.getString(2));
                freelancer.setCin(resultSet.getString(3));
                freelancer.setJob(resultSet.getString(4));
            }
            return freelancer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            this.dbConnection.disconnect();
        }
    }

    @Override
    public Freelancer getFreelancerById(int freelancerId) throws IOException, SQLException {
        try {
            Freelancer freelancer = new Freelancer();
            String query = "Select * from  freelancer    WHERE id = ?";
            PreparedStatement statement = this.dbConnection.connect().prepareStatement(query);
            statement.setInt(1,freelancerId);
            ResultSet  resultSet = statement.executeQuery();;
            while(resultSet.next())
            {
                freelancer.setId(resultSet.getInt(1));
                freelancer.setName(resultSet.getString(2));
                freelancer.setSecondName(resultSet.getString(3));
                freelancer.setCin(resultSet.getString(4));
                freelancer.setJob(resultSet.getString(5));
            }
            return freelancer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            this.dbConnection.disconnect();
        }
    }

}
