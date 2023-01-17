package org.sid.services.mark;

import org.sid.DTO.mark.Request.MarkRequest;
import org.sid.DTO.mark.Response.MarkResponse;

import java.util.List;

public interface MarkService {

    public  Boolean saveMark (MarkRequest markRequest);
    public List<MarkResponse> getMarksByStudent(Long studentId);

}
