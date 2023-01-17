package org.sid.services.absence;

import org.sid.DAL.AbsenceRepositoryImpl;
import org.sid.DTO.absence.Request.AbsenceRequest;
import org.sid.DTO.absence.Response.AbsenceResp;
import org.sid.DTO.absence.Response.AbsenceResponse;
import org.sid.entities.Absence;
import org.sid.repositories.AbsenceRepository;
import org.sid.utils.AbsenceDate;

import java.util.ArrayList;
import java.util.List;

public class AbsenceServiceImpl  implements  AbsenceService{

    private AbsenceRepository absenceRepository ;

    public  AbsenceServiceImpl()
    {
        this.absenceRepository = new AbsenceRepositoryImpl();
    }
    @Override
    public Absence saveAbsence(AbsenceRequest absenceRequest) {

        return null;
    }

    @Override
    public List<AbsenceResp> getAbsenceByStudent(Long studentId) {
        List<AbsenceResponse> absenceResponses = this.absenceRepository.getAbsencesByStudent(studentId);
        if(absenceResponses.size() > 0 )
        {
            // La list des absence que je vais passer vers la page js ,  pour chaque module on afficher une list des dates pour lesquelles l"etudiant a absentées LIST < Absence Respo>
            List<AbsenceResp> absenceRespList = new ArrayList<>();
            //  Pour chaque module on creer une insitance de type absence , et apres on l'insere dans la list des absences  // module + prof + LIST <absenceDate >
            AbsenceResp absenceResp  = new AbsenceResp();
            // une instance  pour chaque absence : date : timeStamp + nombre d'heure .
            AbsenceDate absenceDate = new AbsenceDate();
            //
            int j=0 ;
            // le max possible c'est lorsque tous les lignes retirés de la bases de donnees concerne des modules different
            // C est pour quoi j 'ai mis i<absenceResponses
            // Mais toujour le saut doit etre inferieur a  la dimension
            for(int i=0 ; i<absenceResponses.size() && j<absenceResponses.size() ; i++)
            {
                absenceResp.setAbsence_id(absenceRespList.get(j).getAbsence_id());
                absenceResp.setModul_name(absenceRespList.get(j).getModul_name());
                absenceResp.setProfessor_name(absenceRespList.get(j).getProfessor_name());
                String moduleName = absenceResponses.get(j).getModul_name();
                for(int k=0 ; k<absenceResponses.size() ; i++)
                {
                    // On distingue un nouveau module qui est diffrent du celui en premiere => on doit faire le saut . et sortir
                    if(! absenceResponses.get(k).getModul_name().equals(moduleName))
                    {
                        absenceRespList.add(absenceResp);
                        j=k ;
                        break ;
                    }
                    absenceDate.setAbsence_hour(absenceResponses.get(k).getAbsence_hour());
                    absenceResp.getAbsenceDates().add(absenceDate);
                }
            }
            return absenceRespList ;
        }
        return null;
    }


}
