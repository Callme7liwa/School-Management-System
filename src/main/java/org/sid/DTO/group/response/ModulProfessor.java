package org.sid.DTO.group.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.sid.DTO.UtilsClass.ModulProfessorAffectationUtil;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModulProfessor {

    private Integer group_id ; 
    private String  group_name ; 
    private String  group_abbreviation ; 
    List<ModulProfessorAffectationUtil> moduls_professors = new ArrayList<ModulProfessorAffectationUtil>();

    
}
