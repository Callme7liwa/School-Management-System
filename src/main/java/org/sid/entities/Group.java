package org.sid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Data
public class Group {
    private Integer group_id ;
    private String group_name;
    private String group_abbreviation ; 
    private Date group_creationDate ;
    private String group_year ; 
    private Field field ; 

    public Group()
    {
        new Field();
    }
}
