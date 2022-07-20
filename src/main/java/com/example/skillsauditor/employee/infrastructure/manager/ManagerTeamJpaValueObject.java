package com.example.skillsauditor.employee.infrastructure.manager;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name="manager_team")
@Table(name="manager_team")
@Setter
@Getter
@ToString
public class ManagerTeamJpaValueObject {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "team_sequence",
            sequenceName = "team_sequence_id",
            allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="team_sequence")
    private long id;

    @Column(name = "staff_id")
    private String staff;

    @Column(name = "manager_id")
    private String manager;

    public ManagerTeamJpaValueObject(){}

    public ManagerTeamJpaValueObject(
            long id
    ) {
        this.id = id;
    }

    public static ManagerTeamJpaValueObject managerTeamJpaOf(Long id) {
        return new ManagerTeamJpaValueObject(id);
    }
}
