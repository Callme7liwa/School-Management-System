package org.sid.DTO.level.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelListResponseDTO {
    private Integer level_id  ; 
    private String  level_abbreviation  ;
    private String  level_name ; 
    private Integer level_groups ;
    private Integer level_students ; 
    
}
