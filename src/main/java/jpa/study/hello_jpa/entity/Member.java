package jpa.study.hello_jpa.entity;

import lombok.*;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleTypes;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyAt;

    @Lob
    private String description;

    @Transient
    private String tmp;


}
