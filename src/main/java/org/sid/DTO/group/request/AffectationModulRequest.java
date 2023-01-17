package org.sid.DTO.group.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AffectationModulRequest {

    private Integer modul_id ; 
    private Integer group_id;
    private Integer professor_id ; 
    private String affectation_date ; 
    
}
