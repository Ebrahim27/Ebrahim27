package com.eki.ee.realbank.repositories.bank;//package com.eki.ee.banks.repositories.bank;
//
//import com.eki.ee.banks.domin.bankk.AdvancedCriteria;
//import com.eki.ee.banks.domin.bankk.Bank;
//import com.eki.ee.banks.domin.model.Bank_;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//
//import javax.persistence.criteria.Predicate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class BankSpecifications implements JpaSpecificationExecutor<Bank>  {
//
//
//
//    @Override
//    public Specification<Bank> buildPredicates(List<AdvancedCriteria> criterias) {
//        Specification<Bank> jpaSpecification = super.buildPredicates(criterias);
//
//        Specification<BankSpecifications> joinsSpec = (root, cq, cb) -> {
//            List<Predicate> predicates = new ArrayList<>();
//       cq.multiselect(root.get(Bank_.ID),root.get(Bank_.ACCOUNT_NUMBER),root.get(Bank_.ACCOUNT_NAME),
//                    root.get(Bank_.ACCOUNT_FAMILY_NAME)
//       );
//            return cb.and(predicates.toArray(new Predicate[0])) ;
//        };
//        return Specification.where(jpaSpecification).and(joinsSpec);
//    }
//
//
//
//
//
//    public static Specification<BankSpecifications> findBy_BankAccount(String BankAccount) {
//
//        Specification<BankSpecifications> joinsSpec = (root, cq, cb) -> {
//            List<Predicate> predicates = new ArrayList<>();
//
//    cq.multiselect(root.get(Bank_.ID),root.get(Bank_.ACCOUNT_NUMBER),root.get(Bank_.ACCOUNT_NAME),
//            root.get(Bank_.ACCOUNT_FAMILY_NAME),root.get(Bank_.BALANCE_AMOUNT));
//            final Predicate BankPredicate = cb.equal((root.get(Bank_.BALANCE_AMOUNT)), BankAccount);
//            predicates.add(BankPredicate);
//
//            return cb.and(predicates.toArray(new Predicate[0]));
//        };
//        return Specification.where(joinsSpec);
//
//    }
//
//    @Override
//    public Optional < Bank > findOne ( Specification < Bank > spec ) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List < Bank > findAll ( Specification < Bank > spec ) {
//        return null;
//    }
//
//    @Override
//    public Page < Bank > findAll ( Specification < Bank > spec, Pageable pageable ) {
//        return null;
//    }
//
//    @Override
//    public List < Bank > findAll ( Specification < Bank > spec, Sort sort ) {
//        return null;
//    }
//
//    @Override
//    public long count ( Specification < Bank > spec ) {
//        return 0;
//    }
//}