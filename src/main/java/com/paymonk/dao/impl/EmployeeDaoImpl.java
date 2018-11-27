package com.paymonk.dao.impl;

import com.paymonk.dao.EmployeeDao;
import com.paymonk.domain.Employee;
import com.paymonk.model.EmployeeCO;
import com.paymonk.model.EmployeeDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();

    }

    @Override
    public Employee save(EmployeeCO employeeCO) {
        Session session = currentSession();
        session.beginTransaction();
        Employee employee = new Employee();
        employee.setName(employeeCO.getName());
        employee.setDesignation(employeeCO.getDesignation());
        employee.setExperties(employeeCO.getExperties());
        employee.setEmployeeId("123456");
        session.persist(employee);
        session.getTransaction().commit();
        session.close();
        return employee;
    }

    @Override
    public EmployeeDTO getEmployeeId(long id) {
        Session session = currentSession();
        session.beginTransaction();
        Employee emp = session.get(Employee.class, id);
        session.getTransaction().commit();
        session.close();
        EmployeeDTO empDto = new EmployeeDTO(emp.getId(), emp.getEmployeeId(), emp.getName(),
                emp.getExperties(), emp.getDesignation());

        return empDto;

    }
/*
    @Override
    public List<Employee> list() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        cq.select(root);
        Query<Employee> query = session.createQuery(cq);
        List<Employee> list = query.getResultList();
        session.getTransaction().commit();
        return query.getResultList();
    }
*/
    @Override
    public void update(long id, EmployeeCO employeeCO) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Employee employeeC1 = session.byId(Employee.class).load(id);
        employeeC1.setName(employeeC1.getName());
        employeeC1.setExperties(employeeC1.getExperties());
        employeeC1.setDesignation(employeeC1.getDesignation());
        tx.commit();
        session.close();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Employee emp = new Employee();
        session.delete(emp);
        tx.commit();
        session.close();
    }


    @Override
    public List<EmployeeDTO> listValue() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<EmployeeDTO> criteria = builder.createQuery(EmployeeDTO.class);
        Root<Employee> root = criteria.from(Employee.class);
        criteria.select(builder.construct(EmployeeDTO.class, root));
        //Query<Employee> query = session.createQuery(cq);
        List<EmployeeDTO> list = session.createQuery(criteria).getResultList();//query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }

}

