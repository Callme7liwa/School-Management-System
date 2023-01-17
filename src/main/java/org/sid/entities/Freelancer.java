package org.sid.entities;

import java.util.List;

public class Freelancer {
    private int id ;
    private String name ;
    private String secondName ;
    private String cin ;
    private String job ;
    private List<String> skills ;

    public void setId(int id)
    {
        this.id=id ;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setSecondName(String secondName)
    {
        this.secondName=secondName ;
    }
    public void setCin(String cin)
    {
        this.cin=cin ;
    }
    public void setJob(String job)
    {
        this.job=job ;
    }
    public int getId()
    {
        return  this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public String getSecondName()
    {
        return this.secondName;
    }

    public String getCin()
    {
        return this.cin;
    }

    public String getJob()
    {
        return this.job;
    }

    public List<String> getSkills() {
        return skills;
    }
}
