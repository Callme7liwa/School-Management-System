package org.sid.DTO.field.response;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldEditResponseDao {

    private Integer field_id ; 
    private String field_name ; 
    private String field_abbreviation ; 
    private String field_description ; 
    private Date field_creationDate ; 
    
    
}
