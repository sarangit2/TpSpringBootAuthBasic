package com.kalanso.coaching.Repository;


import com.kalanso.coaching.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}



