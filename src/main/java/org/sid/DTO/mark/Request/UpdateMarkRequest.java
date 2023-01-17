package org.sid.DTO.mark.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateMarkRequest {

    private Integer modul_id ; 
    private Integer student_id ; 
    private Float modul_mark ; 
    
}
