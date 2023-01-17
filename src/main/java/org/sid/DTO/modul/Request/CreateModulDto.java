package org.sid.DTO.modul.Request;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateModulDto {

    private String modul_name ; 
    private String modul_abbreviation ; 
    private String modul_creationDate ; 
}
