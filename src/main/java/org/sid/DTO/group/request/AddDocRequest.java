package org.sid.DTO.group.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddDocRequest {

    private Integer group_id ; 
    private String group_abbreviation ; 
    private String file_name ; 
    private String file_path ; 
    private String file_extension ; 

    
}
