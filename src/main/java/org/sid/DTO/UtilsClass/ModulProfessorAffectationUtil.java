package org.sid.DTO.UtilsClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModulProfessorAffectationUtil {
    private Integer modul_id ; 
    private String  modul_name ; 
    private String  modul_abbreviation ; 
    private Integer professor_id ; 
    private String  professor_name ; 
    private String  professor_secondName ; 
    private String  professor_imagePath ; 
}
