package org.sid.services;

import org.sid.DAL.FreelancerRepositoryImpl;
import org.sid.entities.Freelancer;
import org.sid.repositories.FreelancerRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class FreelancerServiceImpl implements  FreelancerService{

    private FreelancerRepository freelancerRepository ;
    public FreelancerServiceImpl()
    {
        freelancerRepository = new FreelancerRepositoryImpl();
    }

    @Override
    public void save(Freelancer freelancer) throws IOException, SQLException {
            this.freelancerRepository.save(freelancer);
    }

    @Override
    public void update(Freelancer freelancer) throws IOException {
        this.freelancerRepository.update(freelancer);
    }

    @Override
    public void delete(int id) throws IOException {
        this.freelancerRepository.delete((id));
    }

    @Override
    public ArrayList<Freelancer> getAllFreelancers() throws IOException, SQLException {
        return this.freelancerRepository.getAllFreelancers();
    }

    @Override
    public Freelancer getFreelancer(String cin) throws IOException {
        return null;
    }

    @Override
    public Freelancer getFreelancerById(int freelancerId) throws IOException {
        try {
            return this.freelancerRepository.getFreelancerById(freelancerId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
