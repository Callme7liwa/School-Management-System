package org.sid.DTO.field.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldUpdateRequest {

    private Integer field_id ; 
    private String field_name ; 
    private String field_abbreviation ; 
    private String field_creationDate ; 
    private String field_description ; 
}
