package org.sid.DTO.field.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldSaveRequest {

    private String field_name ; 
    private String field_abbreviation ; 
    private String field_description ; 
    private String field_creationDate ; 
    
}
