package org.sid.DTO.mark.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor@Data
public class MarkResponse {
    private Integer modul_id ;
    private String modul_abbreviation ; 
    private String modul_name;
    private Integer student_id ;
    private Float mark ;
}
