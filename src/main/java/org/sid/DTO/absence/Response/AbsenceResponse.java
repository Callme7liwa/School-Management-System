package org.sid.DTO.absence.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AbsenceResponse {

    private Long absence_id;
    private Integer absence_hour ;
    private Timestamp absence_date ;
    private String professor_name;
    private String modul_name ;
}
