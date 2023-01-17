package org.sid.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.sid.entities.Freelancer;
import org.sid.services.FreelancerService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "AuthenticationController_Other", value = {"/freelancers","/edit_freelancer","/delete_freelancer","/add_freelancer" })
public class AuthenticationController_Other extends SupperController {

    private FreelancerService freelancerService ;

    public AuthenticationController_Other() throws SQLException, IOException {
            this.freelancerService= getFreelancerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        System.out.println("the ction is" +action);
        int freelancerId  ;

        switch(action)
        {
            case "/edit_freelancer"  :
                 freelancerId = Integer.parseInt(req.getParameter("id")) ;
                Freelancer freelancerToUpdate = this.freelancerService.getFreelancerById(freelancerId);
                req.setAttribute("freelancerToUpdate" , freelancerToUpdate);
                req.getRequestDispatcher("vues/authentication/editFreelancer.jsp").forward(req,resp);
                break ;
            case "/delete_freelancer":
                freelancerId = Integer.parseInt(req.getParameter("id")) ;
                System.out.println("im in delte and the id => => " + freelancerId);
                freelancerService.delete(freelancerId);
                resp.sendRedirect("freelancers");
//                request.setAttribute("moduleToUpdate",moduleToUpdate);
//                request.setAttribute("masters",Master.getMasterArrayList());
//                request.setAttribute("modules",Module.getModuleArrayList());
//                request.getRequestDispatcher("vues/manage_modules/edit_module.jsp").forward(request,response);
                break  ;
            case "/add_freelancer" :
                req.getRequestDispatcher("vues/authentication/addFreelancer.jsp").forward(req,resp);
                break ;
            default :
                try {
                    System.out.println("the size is : " + freelancerService.getAllFreelancers().size());
                    req.setAttribute("freelancers",freelancerService.getAllFreelancers());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                req.getRequestDispatcher("vues/authentication/signup.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println("the name " +req.getParameter("name"));
        System.out.println("the action " +req.getParameter("action"));
        System.out.println("the id " +req.getParameter("id"));
        switch (action)
        {
            case "save_freelancer":
                Freelancer freelancer = mapRequestToFreelancer(req);
                try {
                    this.freelancerService.save(freelancer);
                  //  req.getRequestDispatcher("vues/authentication/signup.jsp").forward(req,resp);
                    resp.sendRedirect("freelancers");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break ;
            case "update_freelancer":
                Freelancer freelancer1 = new Freelancer();
                freelancer1.setId(Integer.parseInt(req.getParameter("id")));
                freelancer1.setName(req.getParameter("name"));
                freelancer1.setSecondName(req.getParameter("secondName"));
                freelancer1.setCin(req.getParameter("cin"));
                freelancer1.setJob(req.getParameter("job"));
                this.freelancerService.update(freelancer1);
                resp.sendRedirect("freelancers");
                break ;
            default:
                req.getRequestDispatcher("vues/authentication/signup.jsp").forward(req,resp);
        }
    }

    private  Freelancer mapRequestToFreelancer(HttpServletRequest request)
    {
        Freelancer freelancer = new Freelancer();
        System.out.println("im in ma request to tdo " +request.getParameter("name"));

        if(     !Objects.equals(request.getParameter("name"), "") &&
                !Objects.equals(request.getParameter("secondName"), "") &&
                !Objects.equals(request.getParameter("cin"), "") &&
                !Objects.equals(request.getParameter("job"), ""))
        {

            freelancer.setName(request.getParameter("name"));
            freelancer.setSecondName(request.getParameter("secondName"));
            freelancer.setCin(request.getParameter("cin"));
            freelancer.setJob(request.getParameter("job"));
            return freelancer;
        }
        return null;
    }
}
