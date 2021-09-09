package hrmsfullBackend.hrms.dataaccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsfullBackend.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {

}
