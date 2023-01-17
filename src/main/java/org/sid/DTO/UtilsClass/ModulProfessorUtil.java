package org.sid.DTO.UtilsClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModulProfessorUtil {
    
    private Integer professor_id ; 
    private String professor_name ; 
    private String professor_secondName;
    private String professor_departementName ; 
    private String professor_image ; 
}
