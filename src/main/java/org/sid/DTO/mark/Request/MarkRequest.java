package org.sid.DTO.mark.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarkRequest {
    private  Long student_id ;
    private Long module_id ;
    private Float mark ;
}
