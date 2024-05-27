package org.gfg.JBDL64DBConnectivity.repositories;

import org.gfg.JBDL64DBConnectivity.model.Myperson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

//we are creating as a interface So that we can use all the methods provided by JPA
//if we use it as a class then we have to write down all the methods in the JPA Repository.
//Since JpaRepository only deals with Mysql database hence we can use MongoRepository.
public interface MypersonRepository extends JpaRepository<Myperson,Integer> {
}

//public interface MypersonRepository extends MongoRepository<Myperson,Integer> {
//}
