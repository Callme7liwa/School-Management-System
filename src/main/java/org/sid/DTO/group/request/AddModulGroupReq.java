package org.sid.DTO.group.request;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddModulGroupReq {

    private Integer modul_id ; 
    private Integer group_id ; 
    private String affectation_date ; 
    
}
