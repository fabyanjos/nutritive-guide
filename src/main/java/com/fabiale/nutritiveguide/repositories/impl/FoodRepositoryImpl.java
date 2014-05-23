package com.fabiale.nutritiveguide.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.fabiale.nutritiveguide.model.Food;
import com.fabiale.nutritiveguide.repositories.FoodRepository;

@Repository
public class FoodRepositoryImpl extends GenericRepositoryImpl<Food, Integer> implements FoodRepository {
	
	public FoodRepositoryImpl() {
		super(Food.class);
	}

	@SuppressWarnings("unchecked")
	public List<Food> findByName(String name, int maxResults) {
		Criteria criteria = this.getSession().createCriteria(Food.class);
//    	criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE).ignoreCase());
    	criteria.add(Restrictions.sqlRestriction("TRANSLATE({alias}.name,'ÀÁÃáàãÉÈéèÍíÓÒÕóòõÚú','AAAaaaEEeeIiOOOoooUu') ILIKE  '%" + name.replace(" ", "%") + "%'"));  
    	
    	if(maxResults > 0)
    		criteria.setMaxResults(maxResults);
    	
    	criteria.setProjection(Projections.projectionList()
	    			.add(Projections.property("id"), "id")
	    			.add(Projections.property("name"), "name"))
	    		.setResultTransformer(Transformers.aliasToBean(Food.class));
    	
    	return criteria.list();
	}
}
