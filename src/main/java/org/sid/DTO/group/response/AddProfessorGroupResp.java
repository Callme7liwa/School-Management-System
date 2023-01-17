package org.sid.DTO.group.response;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import org.sid.DTO.UtilsClass.ProfessorUtil;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddProfessorGroupResp {

    private Integer group_id ; 
    private String group_abbreviation ; 
    private List<ProfessorUtil> professors  = new ArrayList<ProfessorUtil>() ;
    
}
