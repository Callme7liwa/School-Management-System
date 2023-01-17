package org.sid.DTO.mark.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EditMarkRequest {

    private Integer modul_id ; 
    private Integer student_id ; 
    private String modul_abbreviation;
    private Float modul_mark;
    
}
