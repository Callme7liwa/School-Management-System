package org.sid.DAL;

import org.sid.DTO.absence.Request.AbsenceRequest;
import org.sid.DTO.absence.Response.AbsenceResponse;
import org.sid.connection.DBConnection;
import org.sid.entities.Absence;
import org.sid.entities.Student;
import org.sid.repositories.AbsenceRepository;
import org.sid.utils.FunctionUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AbsenceRepositoryImpl extends RepositoryImplSuper<AbsenceResponse> implements AbsenceRepository {

    @Override
    public Boolean saveAbsence(AbsenceRequest absenceRequest) {

        try {
            this.dbConnection = new DBConnection();
            this.query = "INSERT INTO modul_absence(student_id ,professeur_id ,  module_id ,absence_hour , absence_date ) VALUES(?,?,?,?)";
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.statement.setLong(1,absenceRequest.getStudent_id());
            this.statement.setLong(2,absenceRequest.getProfessor_id());
            this.statement.setLong(3 , absenceRequest.getModule_id());
            this.statement.setInt(4 , absenceRequest.getAbsence_hour());
            this.statement.setTimestamp(5 , FunctionUtils.getCurrentDate("dd/MM/yyyy HH:mm:ss"));
            this.statement.executeUpdate();
            this.statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            this.dbConnection.disconnect();
        }
        return false ;
    }

    

    @Override
    public List<AbsenceResponse> getAbsencesByStudent(Long studentId) {
        try {
            this.dbConnection = new DBConnection();
            this.query = "SELECT  m.module_name , p.professor_name , mb.absence_id , mb.absence_hour , mb.absence_date "
            + "from modul m , modul_absence mb , professor p"
            + "where mb.modul_Id = m.modul_id and p.professor_id = mb.professor_id and mb.student_id="+studentId
                    +"ORDER BY  m.module_name";
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet  = this.statement.executeQuery();
            this.list_t= new ArrayList<>();
            this.t  = new AbsenceResponse();
            while(resultSet.next())
            {
                this.t.setAbsence_id((long) this.resultSet.getInt("absence_id"));
                this.t.setAbsence_date(this.resultSet.getTimestamp("absence_date"));
                this.t.setAbsence_hour(this.resultSet.getInt("absence_hour"));
                this.t.setModul_name(this.resultSet.getString("module_name"));
                this.t.setModul_name(this.resultSet.getString("professor_name"));
                this.list_t.add(this.t);
            }
            this.statement.executeUpdate();
            this.statement.close();
        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}


