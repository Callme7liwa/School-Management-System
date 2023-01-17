package org.sid.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public  class AbsenceDate  {
    private Date absence_date ;
    private Integer absence_hour ;
}