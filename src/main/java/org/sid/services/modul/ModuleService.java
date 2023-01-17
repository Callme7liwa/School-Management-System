package org.sid.services.modul;

import org.sid.DTO.modul.Request.CreateModulDto;
import org.sid.DTO.modul.Response.ModulFields;
import org.sid.DTO.modul.Response.ModulGroups;
import org.sid.DTO.modul.Response.ModulProfessors;
import org.sid.DTO.modul.Response.ModulResponseDto;
import org.sid.entities.Module;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ModuleService {

    public Boolean saveModule(CreateModulDto createModulDto) throws IOException, SQLException;
    public ModulResponseDto getModule(Integer modul_id) throws IOException, SQLException;
    public Module getModul(Integer modul_id) throws IOException , SQLException ;
    public List<ModulResponseDto> getModules() throws IOException, SQLException ;
    public Boolean deleteModule(Long moduleId) throws IOException, SQLException ;
    public Module updateModule(Module Module) throws IOException, SQLException ;
    public List<Module> getModulesByStudent(Long stundetId) throws IOException, SQLException ;
    public List<Module> getModulesByProfessor(Long professorId) throws IOException , SQLException;
    //
    public ModulFields getFieldsByModul(Integer modul_id)throws IOException , SQLException ;
    public ModulGroups getGroupsByModul(Integer modul_id)throws IOException , SQLException ;
    public ModulProfessors getProfessorsByModul(Integer modul_id)throws IOException , SQLException ;

    

}
