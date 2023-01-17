package org.sid.DAL;

import org.sid.DTO.mark.Request.MarkRequest;
import org.sid.DTO.mark.Response.MarkResponse;
import org.sid.connection.DBConnection;
import org.sid.entities.Mark;
import org.sid.repositories.MarkRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarkRepositoryImpl extends RepositoryImplSuper<MarkResponse> implements MarkRepository {
    @Override
    public Boolean saveMark(MarkRequest request) {
        return null;
    }

    @Override
    public List<MarkResponse> getMarksByStudent(Long studentId) {
        try{
            this.dbConnection = new DBConnection();
            this.query =
                    "SELECT m.module_id , m.module_name , p.professor_name , p.professor_id , ms.mark from  module m , professor p , mark_student ms "+
                    "m.module_id = ms.module_id and ms.professor_id = p.professor_id and ms.student_id ="+studentId+
                    "GROUP BY m.module_name";
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            this.list_t = new ArrayList<MarkResponse>();
            this.t = new MarkResponse();
            while(this.resultSet.next())
            {
                //
            }
            this.resultSet.close();
            this.statement.close();
            return  this.list_t;
        }catch ( SQLException e )
        {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            this.dbConnection.disconnect();
        }
        return null ;
    }
}
