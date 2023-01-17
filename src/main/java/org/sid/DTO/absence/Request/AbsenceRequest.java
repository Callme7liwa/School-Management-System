package org.sid.DTO.absence.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AbsenceRequest {
    private Long student_id ;
    private Long professor_id ;
    private Long module_id ;
    private Integer absence_hour ;
}
