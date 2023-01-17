package org.sid.DTO.modul.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleModulDto {
    private Integer  modul_id ; 
    private String modul_name ; 
    private String modul_abbreviation ; 
}
