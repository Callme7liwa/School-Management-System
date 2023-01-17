package org.sid.DTO.group.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupSaveDtoReq {

    private String group_name ; 
    private String group_abbreviation ; 
    private Integer level_id ; 
    private String group_creationDate ; 
    
}
