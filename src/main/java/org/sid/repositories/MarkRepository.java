package org.sid.repositories;

import org.sid.DTO.mark.Request.MarkRequest;
import org.sid.DTO.mark.Response.MarkResponse;

import java.util.List;

public interface MarkRepository {

    public Boolean saveMark(MarkRequest request);
    public List<MarkResponse> getMarksByStudent(Long studentId);
}
