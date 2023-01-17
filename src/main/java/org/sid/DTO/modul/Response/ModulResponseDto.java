package org.sid.DTO.modul.Response;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.sid.DTO.UtilsClass.FieldUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ModulResponseDto {

    private Integer  modul_id ; 
    private String modul_name ; 
    private String modul_abbreviation ; 
    private Date modul_creationDate ; 
    private Integer groups_number ; 
    private Integer professor_numbers ; 
    private List<FieldUtil> fields  = new ArrayList<>(); 
    
}
