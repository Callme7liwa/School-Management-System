package org.sid.services.mark;

import org.sid.DAL.MarkRepositoryImpl;
import org.sid.DTO.mark.Request.MarkRequest;
import org.sid.DTO.mark.Response.MarkResponse;
import org.sid.repositories.MarkRepository;

import java.util.List;

public class MarksServiceImpl  implements MarkService {

    private MarkRepository markRepository ;

    public MarksServiceImpl()
    {
        this.markRepository = new MarkRepositoryImpl();
    }

    @Override
    public Boolean saveMark(MarkRequest markRequest) {
        return null;
    }

    @Override
    public List<MarkResponse> getMarksByStudent(Long studentId) {
        List<MarkResponse> markResponses =  markRepository.getMarksByStudent(studentId);
        return markResponses ;
    }
}
