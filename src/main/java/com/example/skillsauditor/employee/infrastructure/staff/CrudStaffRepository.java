package com.example.skillsauditor.employee.infrastructure.staff;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CrudStaffRepository extends CrudRepository<StaffJpa, String> {

    @Modifying
    @Query(value = "delete from staff_skills where staff_skills.skill_id = ?1 AND staff_skills.staff_id = ?2", nativeQuery = true)
    void deleteStaffSkill(String skillId, String staffId);

}
