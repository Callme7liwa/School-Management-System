package org.sid.services.modul;

import org.sid.DAL.ModuleRepositoryImpl;
import org.sid.DTO.modul.Request.CreateModulDto;
import org.sid.DTO.modul.Response.ModulFields;
import org.sid.DTO.modul.Response.ModulGroups;
import org.sid.DTO.modul.Response.ModulProfessors;
import org.sid.DTO.modul.Response.ModulResponseDto;
import org.sid.entities.Module;
import org.sid.repositories.ModuleRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ModuleServiceImpl  implements  ModuleService{

    private ModuleRepository moduleRepository ;
    public ModuleServiceImpl()
    {
        this.moduleRepository = new ModuleRepositoryImpl();
    }

    @Override
    public Boolean saveModule(CreateModulDto createModulDto) throws IOException, SQLException {
        Boolean responseState = this.moduleRepository.saveModule(createModulDto);
        return responseState;
    }

    @Override
    public ModulResponseDto getModule(Integer modul_id) throws IOException, SQLException {
        ModulResponseDto modulResponseDto = this.moduleRepository.getModule(modul_id);
        return modulResponseDto;
    }

    @Override
    public List<ModulResponseDto> getModules() throws IOException, SQLException {
        List<ModulResponseDto> moduls = this.moduleRepository.getModules();
        return moduls;
    }

    @Override
    public Boolean deleteModule(Long moduleId) throws IOException, SQLException {
        return null;
    }

    @Override
    public Module updateModule(Module Module) throws IOException, SQLException {
        return null;
    }

    @Override
    public List<Module> getModulesByStudent(Long stundetId) throws IOException, SQLException {
        List<Module> modules = this.moduleRepository.getModulesByStudent(stundetId);
        return modules ;
    }

    @Override
    public List<Module> getModulesByProfessor(Long professorId) throws IOException, SQLException {
        List<Module> modules = this.moduleRepository.getModulesByProfessor(professorId);
        return modules ;
    }

    @Override
    public ModulFields getFieldsByModul(Integer modul_id) throws IOException, SQLException {
        ModulFields fields = this.moduleRepository.getFieldsByModul(modul_id);
        return fields;
    }

    @Override
    public ModulGroups getGroupsByModul(Integer modul_id) throws IOException, SQLException {
        ModulGroups moduls = this.moduleRepository.getGroupsByModul(modul_id);    
        return moduls;
    }

    @Override
    public ModulProfessors getProfessorsByModul(Integer modul_id) throws IOException, SQLException {
        ModulProfessors professors = this.moduleRepository.getProfessorsByModul(modul_id);
        return professors;
    }

    @Override
    public Module getModul(Integer modul_id) throws IOException, SQLException {
        Module module = this.moduleRepository.getModul(modul_id);
        return module;
    }
}
