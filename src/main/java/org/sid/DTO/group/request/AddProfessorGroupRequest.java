package org.sid.DTO.group.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProfessorGroupRequest {
    private Integer professor_id ; 
    private Integer group_id ; 
}
