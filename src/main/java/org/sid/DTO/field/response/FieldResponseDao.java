package org.sid.DTO.field.response;


import org.sid.entities.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldResponseDao {
    private Field field ; 
    private Integer student_number ; 
    private Integer group_number ; 
}
