package org.sid.services;

import org.sid.entities.Freelancer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface FreelancerService {

    void save(Freelancer freelancer) throws IOException, SQLException;
    void update(Freelancer freelancer) throws IOException ;
    void delete(int id) throws IOException ;
    public ArrayList<Freelancer> getAllFreelancers() throws IOException,SQLException;
    public Freelancer getFreelancer(String cin) throws IOException;
    public Freelancer getFreelancerById(int id) throws IOException ;

}
