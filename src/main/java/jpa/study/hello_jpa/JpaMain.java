package jpa.study.hello_jpa;

import jpa.study.hello_jpa.entity.Member;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.logging.Logger;

public class JpaMain {

    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin(); // Transaction Start

        try {

//            em.persist(Member.builder().name("hihi JPA")); // Set Persistence Data
            Member find = em.find(Member.class, 1L);

            System.out.println(find.getPid());
            System.out.println(find.getName());

            tx.commit(); // Transaction Commit
            em.close(); // EntityManager Close
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            emf.close();
        }


    }

}
