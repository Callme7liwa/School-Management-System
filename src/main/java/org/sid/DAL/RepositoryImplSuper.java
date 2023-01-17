package org.sid.DAL;

import org.sid.connection.DBConnection;
import org.sid.entities.Student;
import java.util.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RepositoryImplSuper <T> {
    protected String query ;
    protected PreparedStatement statement ;
    protected DBConnection dbConnection;

    protected T t  ;
    protected List<T> list_t ;
    protected ResultSet resultSet ;
}
