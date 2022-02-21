package com.eki.ee.realbank.repositories;//package com.eki.ee.banks.repositories;
//
//import com.eki.ee.banks.domin.bankk.AdvancedCriteria;
//import com.eki.ee.banks.domin.repositories.SearchOperationEnum;
//
//import org.springframework.data.jpa.domain.Specification;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.Expression;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import javax.persistence.metamodel.Attribute;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Set;
//
//public  class GeneralSpecifications<T> {
//    public  Specification<T> buildPredicates(List< AdvancedCriteria > criteria) {
//        return (root, cq, cb) -> {
//
//            List< Predicate > predicates = new ArrayList <>();
//            Set < Attribute <? super T, ?> > attributes = root.getModel().getAttributes();
//            List<AdvancedCriteria> tempList = new ArrayList <AdvancedCriteria >();
//            // remove join properties from list.
//            attributes.removeIf(Attribute::isAssociation);
//
//            for (AdvancedCriteria c : criteria) {
//                for (Attribute a : attributes) {
//                    if (c.getKey().equals(a.getName()) && !a.getJavaType().isEnum() && !a.getJavaType().equals(Date.class)) {
//                        tempList.add(c);
//                    }
//                }
//            }
//
//
//
//            for (AdvancedCriteria advancedCriteria : tempList) {
//                predicates.add(
//                        buildPredicate(
//                                root,
//                                cb,
//                                advancedCriteria.getOperator(),
//                                advancedCriteria.getKey(),
//                                advancedCriteria.getValue()
//                        )
//                );
//            }
//            return cb.and(predicates.toArray(new Predicate[0]));
//        };
//    }
//    protected Predicate buildPredicate( Root <T> root, CriteriaBuilder cb, String operator, String key, String value) {
//
//        if (operator.equals(SearchOperationEnum.EQUAL.getType())) {
//            return getEqualPredicate(root, cb, key, value);
//        } else if (operator.equals(SearchOperationEnum.NOT_EQUAL.getType())) {
//            return getNotEqualPredicate(root, cb, key, value);
//        } else if (operator.equals(SearchOperationEnum.CONTAIN.getType())) {
//            return getContainPredicate(root, cb, key, value);
//        } else if (operator.equals(SearchOperationEnum.NOT_CONTAIN.getType())) {
//            return getNotContainPredicate(root, cb, key, value);
//        } else if (operator.equals(SearchOperationEnum.MATCH_END.getType())) {
//            return getMatchEndPredicate(root, cb, key, value);
//        } else if (operator.equals(SearchOperationEnum.MATCH_START.getType())) {
//            return getMatchStartPredicate(root, cb, key, value);
//        } else if (operator.equals(SearchOperationEnum.GREATER_THAN.getType())) {
//            return getGreaterThanPredicate(root, cb, key, value);
//        } else if (operator.equals(SearchOperationEnum.GREATER_THAN_EQUAL.getType())) {
//            return getGreaterThanEqualPredicate(root, cb, key, value);
//        } else if (operator.equals(SearchOperationEnum.LESS_THAN.getType())) {
//            return getLessThanPredicate(root, cb, key, value);
//        } else if (operator.equals(SearchOperationEnum.LESS_THAN_EQUAL.getType())) {
//            return getLessThanEqualPredicate(root, cb, key, value);
//        } else
//            return getEqualPredicate(root, cb, key, value);
//    }
//
//    protected Predicate buildPredicate( Expression <T> root, CriteriaBuilder cb, String operator, String value) {
//
//        if (operator.equals(SearchOperationEnum.EQUAL.getType())) {
//            return getEqualPredicate(root, cb, value);
//        } else if (operator.equals(SearchOperationEnum.NOT_EQUAL.getType())) {
//            return getNotEqualPredicate(root, cb, value);
//        } else return null;
//    }
//
//    private Predicate getEqualPredicate(Root<T> root, CriteriaBuilder cb, String key, String value) {
//        return cb.equal(
//                root.get(key),
//                value);
//    }
//
//    private Predicate getEqualPredicate(Expression<T> exp, CriteriaBuilder cb, String value) {
//        return cb.equal(
//                exp,
//                value);
//    }
//
//    private Predicate getEqualPredicate(CriteriaBuilder cb, Expression<T> exp1, Expression<T> exp2) {
//        return cb.equal(
//                exp1,
//                exp2);
//    }
//
//    private Predicate getEqualPredicate(CriteriaBuilder cb, Expression<T> exp1, Object obj) {
//        return cb.equal(
//                exp1,
//                obj);
//    }
//
//    private Predicate getNotEqualPredicate(Root<T> root, CriteriaBuilder cb, String key, String value) {
//        return cb.notEqual(
//                root.get(key),
//                value);
//    }
//
//    private Predicate getNotEqualPredicate(Expression<T> exp, CriteriaBuilder cb, String value) {
//        return cb.notEqual(
//                exp,
//                value);
//    }
//
//    private Predicate getContainPredicate(Root<T> root, CriteriaBuilder cb, String key, String value) {
//        return cb.like(
//                root.get(key),
//                "%" + value + "%");
//    }
//
//    private Predicate getNotContainPredicate(Root<T> root, CriteriaBuilder cb, String key, String value) {
//        return cb.not(
//                root.get(key)).in(value);
//    }
//
//    private Predicate getMatchEndPredicate(Root<T> root, CriteriaBuilder cb, String key, String value) {
//        return cb.like(
//                root.get(key),
//                value + "%");
//    }
//
//    private Predicate getMatchStartPredicate(Root<T> root, CriteriaBuilder cb, String key, String value) {
//        return cb.like(
//                root.get(key),
//                "%" + value);
//    }
//
//    private Predicate getGreaterThanPredicate(Root<T> root, CriteriaBuilder cb, String key, String value) {
//        return cb.greaterThan(
//                root.get(key), value);
//    }
//
//    private Predicate getGreaterThanEqualPredicate(Root<T> root, CriteriaBuilder cb, String key, String value) {
//        return cb.greaterThanOrEqualTo(
//                root.get(key), value);
//    }
//
//    private Predicate getLessThanPredicate(Root<T> root, CriteriaBuilder cb, String key, String value) {
//        return cb.lessThan(
//                root.get(key), value);
//    }
//
//    private Predicate getLessThanEqualPredicate(Root<T> root, CriteriaBuilder cb, String key, String value) {
//        return cb.lessThanOrEqualTo(
//                root.get(key), value);
//    }
//}