package org.sid.DTO.event.Request;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {

    private String event_title ; 
    private String event_description ;
    private Date event_date ; 
    private String event_local ;
    private String event_filePath ; 
    private String event_fileExtension ; 
    
}
