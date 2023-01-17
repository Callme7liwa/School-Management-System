package org.sid.entities;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Module {
    private Integer modul_id ;
    private String modul_name ;
    private String modul_description ;
    private String modul_abbreviation ; 
    private Date modul_creationDate;
}
