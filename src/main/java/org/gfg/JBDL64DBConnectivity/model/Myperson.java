package org.gfg.JBDL64DBConnectivity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Myperson {

    @Id
    private Integer id;

    private  String fName;
}
