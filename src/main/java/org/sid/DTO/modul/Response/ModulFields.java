package org.sid.DTO.modul.Response;
import java.util.ArrayList;
import java.util.List;

import org.sid.DTO.UtilsClass.ModulFieldsUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModulFields {

    private Integer modul_id ; 
    private String  modul_abbreviation ; 
    private String  modul_name ; 
    private List<ModulFieldsUtil> fields = new ArrayList<ModulFieldsUtil>();
    
}
