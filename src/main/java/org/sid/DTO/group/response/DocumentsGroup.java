package org.sid.DTO.group.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.sid.DTO.UtilsClass.GroupDocUtil;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentsGroup {
    private Integer group_id ; 
    private String group_name ; 
    private String group_abbreviation ;
    private List<GroupDocUtil> documents = new ArrayList<GroupDocUtil>() ; 
    
}
