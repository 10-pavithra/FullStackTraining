package com.training.makerchecker.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.training.makerchecker.model.Checker;
import com.training.makerchecker.vo.CheckerVO;

public class CheckerSpecification {
	public static Specification<Checker> getAuditDetailSpecification (final CheckerVO criteria){

        return new Specification<Checker>(){
            public Predicate toPredicate(Root<Checker> root, CriteriaQuery<?> cq, CriteriaBuilder cb){
              List<Predicate> predicateList = new ArrayList<Predicate>();

              if(criteria != null){
                  if (!StringUtils.isEmpty(criteria.getCreatedBy()))
                  {
                      Predicate predicate= cb.equal(root.get("createdBy"),criteria.getCreatedBy());
                      predicateList.add(predicate);
                  }
                  if (criteria.getCreatedDate() != null)
                  {
                      Predicate predicate= cb.greaterThanOrEqualTo(root.get("createdDate"),criteria.getCreatedDate());
                      predicateList.add(predicate);
                  }

                  if (criteria.getCustomerId()!= null)
                  {
                      Predicate predicate= cb.lessThanOrEqualTo(root.get("customerId"),criteria.getCustomerId());
                      predicateList.add(predicate);
                  }

                  if (!StringUtils.isEmpty(criteria.getStatus()))
                  {
                      Predicate predicate= cb.equal(root.get("status"),criteria.getStatus());
                      predicateList.add(predicate);
                  }

                 

              }
              if(predicateList.size()==0)
                return null;
              return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }

		
        };

	}
}
