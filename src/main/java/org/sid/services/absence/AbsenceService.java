package org.sid.services.absence;

import org.sid.DTO.absence.Request.AbsenceRequest;
import org.sid.DTO.absence.Response.AbsenceResp;
import org.sid.DTO.absence.Response.AbsenceResponse;
import org.sid.entities.Absence;

import java.util.List;

public interface AbsenceService {

    public Absence saveAbsence(AbsenceRequest absenceRequest);
    public List<AbsenceResp> getAbsenceByStudent(Long studentId);;




}
