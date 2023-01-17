package org.sid.DTO.modul.Response;

import java.util.ArrayList;
import java.util.List ;

import org.sid.DTO.UtilsClass.ModulProfessorUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModulProfessors {
    private Integer modul_id ; 
    private String modul_name ; 
    private String modul_abbreviation ; 
    private List<ModulProfessorUtil> professors = new ArrayList<ModulProfessorUtil>();
    
}
