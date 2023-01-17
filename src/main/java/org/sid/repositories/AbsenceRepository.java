package org.sid.repositories;

import org.sid.DTO.absence.Request.AbsenceRequest;
import org.sid.DTO.absence.Request.NewAbsenceRequest;
import org.sid.DTO.absence.Response.AbsenceResponse;

import java.util.List;

public interface AbsenceRepository {

    public Boolean saveAbsence(AbsenceRequest absenceRequest);
    public List<AbsenceResponse> getAbsencesByStudent(Long studentId);
}
