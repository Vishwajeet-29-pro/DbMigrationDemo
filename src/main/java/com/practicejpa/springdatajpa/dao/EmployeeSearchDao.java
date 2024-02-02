package com.practicejpa.springdatajpa.dao;

import com.practicejpa.springdatajpa.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeSearchDao {

    @Autowired
    private EntityManager entityManager;

    public List<Employee> findAllBySimpleQuery(
            String firstName, String lastName, String email
    ){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

        // select * from employee
        Root<Employee> root = criteriaQuery.from(Employee.class);

        // prepare WHERE clause
        Predicate firstNamePredicate = criteriaBuilder.like(root.get("firstName"), "%" + firstName+ "%");

        Predicate lastNamePredicate = criteriaBuilder.like(root.get("lastName"), "%" + lastName+ "%");

        Predicate emailPredicate = criteriaBuilder.like(root.get("email"), "%" + email+ "%");

        Predicate firstNameOrLastnamePredicate = criteriaBuilder.or(firstNamePredicate, lastNamePredicate);

        var andEmailPredicate= criteriaBuilder.and(firstNameOrLastnamePredicate, emailPredicate);
        criteriaQuery.where(andEmailPredicate);

        TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List<Employee> findAllByCriteria(SearchRequest request){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        List<Predicate> predicates = new ArrayList<>();

        // select from employee
        Root<Employee> root = criteriaQuery.from(Employee.class);
        if (request.getFirstName() != null){
            Predicate firstNamePredicate = criteriaBuilder.like(root.get("firstName"),"%" + request.getFirstName() +"%");
            predicates.add(firstNamePredicate);
        }
        if (request.getLastName() != null){
            Predicate lastNamePredicate = criteriaBuilder.like(root.get("lastName"),"%" + request.getLastName() +"%");
            predicates.add(lastNamePredicate);
        }
        if (request.getEmail() != null){
            Predicate emailPredicate = criteriaBuilder.like(root.get("email"),"%" + request.getEmail() +"%");
            predicates.add(emailPredicate);
        }
        criteriaQuery.where(
                criteriaBuilder.or(predicates.toArray(new Predicate[0]))
        );

        TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
