package com.accolite.opportunity.mysql.dao;
import org.springframework.data.repository.CrudRepository;

import com.accolite.opportunity.model.Opportunity;
public interface OpportunityDao extends CrudRepository<Opportunity,Integer> {

}
