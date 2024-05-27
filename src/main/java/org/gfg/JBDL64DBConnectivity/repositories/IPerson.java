package org.gfg.JBDL64DBConnectivity.repositories;

import org.gfg.JBDL64DBConnectivity.Person;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Repository
public interface IPerson {
    List<Person> getAllPerson() throws SQLException;

    boolean insertPerson(Person person) throws SQLException;

    int updatePerson(String name, Integer id) throws SQLException;
}
