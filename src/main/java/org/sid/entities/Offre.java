package org.sid.entities;

import java.util.ArrayList;
import java.util.List;

public class Offre {
    private Long  offre_id ;
    private String offre_name ;
    private String offre_description ;
    private String offre_job ;
    private List<Freelancer> freelancers  = new ArrayList<Freelancer>();
}
