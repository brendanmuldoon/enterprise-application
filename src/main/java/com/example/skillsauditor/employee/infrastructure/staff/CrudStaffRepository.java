package com.example.skillsauditor.employee.infrastructure.staff;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CrudStaffRepository extends CrudRepository<StaffJpa, String> {

}
