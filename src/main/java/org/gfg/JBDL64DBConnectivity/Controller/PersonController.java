package org.gfg.JBDL64DBConnectivity.Controller;

import org.gfg.JBDL64DBConnectivity.Person;
import org.gfg.JBDL64DBConnectivity.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController//Combination of Controller + ResponseBody
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/getPerson")
    public List<Person> getAllPerson() throws SQLException {
        //cnotroller responsibility
        // 1) Validation
        // 2) return the perfect data

        return personService.getAllPerson();

    }
    @PostMapping("/addPerson")
    //ResponseEntity is used for HTTP status also you can add things along with java object
    public ResponseEntity <Boolean> insertData(@RequestBody Person person) throws Exception {
        if(person.getName()==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            //throw  new Exception("name should not be null");
        }
        return new ResponseEntity<>(personService.insetPerson(person),HttpStatus.OK);
    }
    @PutMapping("/updatePerson")
    public int updatePerson(@RequestParam("name") String name, @RequestParam("id") Integer id) throws Exception {
        if(id==null){
            throw new Exception("ID should not be null");
        }
        return personService.updatePerson(name,id);
    }
}
