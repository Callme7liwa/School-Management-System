package org.sid.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Field {
    
    private Integer field_id ; 
    private String field_name ; 
    private String field_abbreviation ; 
    private String field_description ; 
    private Date field_creationDate ; 
}
