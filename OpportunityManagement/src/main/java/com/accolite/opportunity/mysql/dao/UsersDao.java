package com.accolite.opportunity.mysql.dao;
import org.springframework.data.repository.CrudRepository;

import com.accolite.opportunity.model.Users;
public interface UsersDao extends CrudRepository<Users,Integer> {

}
