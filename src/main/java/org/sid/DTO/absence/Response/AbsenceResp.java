package org.sid.DTO.absence.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.utils.AbsenceDate;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AbsenceResp {

    private Long absence_id;
    private String professor_name;
    private String modul_name ;
    private List<AbsenceDate> absenceDates ;

}


