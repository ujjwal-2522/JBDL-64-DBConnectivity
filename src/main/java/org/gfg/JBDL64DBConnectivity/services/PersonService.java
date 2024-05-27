package org.gfg.JBDL64DBConnectivity.services;

import org.gfg.JBDL64DBConnectivity.Person;
import org.gfg.JBDL64DBConnectivity.model.Myperson;
import org.gfg.JBDL64DBConnectivity.repositories.IPerson;
import org.gfg.JBDL64DBConnectivity.repositories.MypersonRepository;
import org.gfg.JBDL64DBConnectivity.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service// internally use @Component
public class PersonService {
    @Autowired
    @Qualifier("personRepository")// this annotation is used for if one bean is required but found 2.
    private IPerson iPerson;
    @Autowired
    private MypersonRepository mypersonRepository;
    public List<Person> getAllPerson() throws SQLException {
       return iPerson.getAllPerson();
    }

    public boolean insetPerson(Person person) throws SQLException {
        Myperson myperson=new Myperson(person.getId(),person.getName());
        Myperson p= mypersonRepository.save(myperson);
        return true;
    }

    public int updatePerson(String name, Integer id) {
        try {
            return iPerson.updatePerson(name,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


//    @Autowired
//    private PersonRepository personRepository;
//    public List<Person> getAllPerson() throws SQLException {
//       return personRepository.getAllPerson();
//    }
//
//    public boolean insetPerson(Person person) throws SQLException {
//        return personRepository.insertPerson(person);
//    }
//
//    public int updatePerson(String name, Integer id) throws SQLException {
//        return personRepository.updatePerson(name,id);
//    }

    //Business logic come under service
    //Interaction between third parties
    // interaction with DB

}
