package org.sid.DTO.group.response;

import org.sid.entities.Group;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class InfoGroupDaoResponse {

    private Group group ; 
    private Integer students_number ; 
    private Integer professors_number ;
    private Integer moduls_number ; 
    
}
