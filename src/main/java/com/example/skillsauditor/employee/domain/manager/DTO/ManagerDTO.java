package com.example.skillsauditor.employee.domain.manager.DTO;

import com.example.skillsauditor.employee.domain.common.EmployeeDTO;
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
public class ManagerDTO extends EmployeeDTO {

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
        super(id, fullname_firstname, fullname_surname, houseNumber, streetName, postcode, role, username, password);
        this.team = team;
    }
}
