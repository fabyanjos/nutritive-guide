package com.fabiale.nutritiveguide.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
		StringBuffer sb = new StringBuffer();
		sb
			.append("TRANSLATE({alias}.name,'ÀÁÃáàãÉÈéèÍíÓÒÕóòõÚú','AAAaaaEEeeIiOOOoooUu') ILIKE  '%")
			.append( name.replace(" ", "%"))
			.append("%'");
    	criteria.add(Restrictions.sqlRestriction(sb.toString()));  
    	
    	if(maxResults > 0)
    		criteria.setMaxResults(maxResults);
    	
    	criteria.setProjection(Projections.projectionList()
	    			.add(Projections.property("id"), "id")
	    			.add(Projections.property("name"), "name"))
	    		.setResultTransformer(Transformers.aliasToBean(Food.class));
    	
    	return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Food> findByElement(String element, int maxResults, Long categoryId) {
		StringBuffer sql = new StringBuffer();
		sql
			.append(" SELECT * FROM food f, food_element fe ")
			.append(" WHERE f.id = fe.food_id AND fe._ELEMENT <> '' AND fe._ELEMENT <> ' ' ")
			.append(" AND fe._ELEMENT <> 'Tr' AND fe._ELEMENT <> 'NA' AND fe._ELEMENT <> '*' ");
			
		if(categoryId != null && categoryId != 0) {
			sql.append(" AND f.category_id = " + categoryId);
		}
		sql.append(" ORDER BY cast(fe._ELEMENT as numeric) DESC ");
			
		Query query = this.getSession().createSQLQuery(sql.toString().replaceAll("_ELEMENT", element))
				.addEntity(Food.class);
		
		if(maxResults > 0)
    		query.setMaxResults(maxResults);
		
		return query.list();

	}
}
