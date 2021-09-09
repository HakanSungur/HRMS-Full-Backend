package hrmsfullBackend.hrms.dataaccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsfullBackend.hrms.entities.concretes.Department;

public interface DeparmentDao extends JpaRepository<Department, Integer> {

}
