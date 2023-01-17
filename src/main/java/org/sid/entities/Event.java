package org.sid.entities;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Event {

    private Integer event_id ; 
    private String event_title ; 
    private String event_description;
    private String event_local ; 
    private Date event_date ; 
    private String event_filePath ; 
    private String event_fileExtension ; 
    
}
