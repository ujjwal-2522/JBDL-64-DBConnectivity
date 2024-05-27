package org.gfg.JBDL64DBConnectivity.repositories;

import org.gfg.JBDL64DBConnectivity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository

public class SpringJDBCPerson implements IPerson{


    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public List<Person> getAllPerson() throws SQLException {
         return jdbcTemplate.query("select * from person", new RowMapper<Person>() {
             @Override
             public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                 Person p=new Person(rs.getString("name"),rs.getInt("id"));
                 return p;
             }
         });
    }

    @Override
    public boolean insertPerson(Person person) throws SQLException {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name" , person.getName());
        parameterSource.addValue("id" , person.getId());

        namedParameterJdbcTemplate.update("insert into person(name,id) VALUES (:name, :id)",parameterSource);
        return false;
    }

    @Override
    public int updatePerson(String name, Integer id) {
        return 0;
    }
}
