package com.paymonk.dao.impl;

import com.paymonk.dao.ManagerDao;
import com.paymonk.domain.Employee;
import com.paymonk.domain.Manager;
import com.paymonk.model.EmployeeDTO;
import com.paymonk.model.ManagerCO;
import com.paymonk.model.ManagerDTO;
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

@Repository("managerDao")
public class ManagerDaoImpl implements ManagerDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public String save(Employee employee, ManagerCO managerCO) {
        Session session = currentSession();
        session.beginTransaction();
        Manager manager = new Manager();
        manager.setEmployee((Employee) session.merge(employee));
        manager.setAddress(managerCO.getAddress());
        manager.setSalary(managerCO.getSalary());
        manager.setDepartment(managerCO.getDepartment());
        session.persist(manager);
        session.getTransaction().commit();
        session.close();
        return employee.getEmployeeId();
    }

     @Override
    public ManagerDTO getManagerId(long id){
        Session session = currentSession();
         session.beginTransaction();
         Manager manager = session.get(Manager.class, id);
         session.getTransaction().commit();
         session.close();
         ManagerDTO managerDTO = new ManagerDTO(manager.getId(),manager.getDepartment(),
                 manager.getSalary(),manager.getAddress());
         return managerDTO;


     }
/*
    @Override
    public List<Manager> list() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Manager> cq = cb.createQuery(Manager.class);
        Root<Manager> root = cq.from(Manager.class);
        cq.select(root);
        Query<Manager> query = session.createQuery(cq);
        List<Manager> list = query.getResultList();
        session.getTransaction().commit();
        return query.getResultList();
    }
*/

    @Override
    public void update(long id, ManagerCO managerCO) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Manager manager1 = session.byId(Manager.class).load(id);
        manager1.setSalary(manager1.getSalary());
        manager1.setDepartment(manager1.getDepartment());
        manager1.setAddress(manager1.getAddress());
        tx.commit();
        session.close();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Manager manager = new Manager();
        session.delete(manager);
        tx.commit();
        session.close();
    }

    @Override
    public List<ManagerDTO> AllList(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ManagerDTO> criteria = builder.createQuery(ManagerDTO.class);
        Root<Manager> root = criteria.from(Manager.class);
        criteria.select(builder.construct(ManagerDTO.class,root));
        //Query<Employee> query = session.createQuery(cq);
        List<ManagerDTO> list = session.createQuery(criteria).getResultList();//query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
