package com.example.skillsauditor.employee.domain.manager.DTO;

import com.example.skillsauditor.employee.domain.common.Role;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class ManagerDTO {

    private String id;
    private String fullname_firstname;
    private String fullname_surname;
    private String houseNumber;
    private String streetName;
    private String postcode;
    private Role role;
    private String username;
    private String password;
    private List<ManagerTeamDTO> team;

    public ManagerDTO(String id,
                      String fullname_firstname,
                      String fullname_surname,
                      String houseNumber,
                      String streetName,
                      String postcode,
                      Role role,
                      String username,
                      String password,
                      List<ManagerTeamDTO> team) {
        this.id = id;
        this.fullname_firstname = fullname_firstname;
        this.fullname_surname = fullname_surname;
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.postcode = postcode;
        this.role = role;
        this.username = username;
        this.password = password;
        this.team = team;
    }
}
