package org.sid.DTO.modul.Response;

import java.util.ArrayList;
import java.util.List;

import org.sid.DTO.UtilsClass.ModulGroupUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ModulGroups {

    private Integer modul_id ; 
    private String modul_name ; 
    private String  modul_abbreviation ; 

    private List<ModulGroupUtil> groups = new ArrayList<ModulGroupUtil>();
    
}
