package com.caps.sms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.caps.sms.beans.Dealer;
@Repository
public class DealerDAOImpl implements DealerDAO {
	
	@PersistenceUnit  
	EntityManagerFactory entityManagerFactory ;
	
	@Override
	public boolean addDealer(Dealer dealer) {
		EntityManager entityManager =  null ;

		boolean state = false;
		try{

			if(dealer!=null)
			{
				entityManager = entityManagerFactory.createEntityManager() ;
				//System.out.println("BEFORE BEGIN");
				entityManager.getTransaction().begin();
//				System.out.println("AFTER BEGIN");
				entityManager.persist(dealer) ;
				//System.out.println(" Dealer added successfully ");
				state =  true;
				return state;
			}

		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {

        
			entityManager.getTransaction().commit();
			entityManager.close();
		}
		return state ;
	}

	@Override
	public Dealer getDealer(int dealerId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println(dealerId);
		Dealer dealer1 =null ;
		try {
			entityManager.getTransaction().begin();
			String jqpl= "select b from Dealer b where  b.dealerId=:dealerId";
			Query query = entityManager.createQuery(jqpl); 
			query.setParameter("dealerId", dealerId);
			dealer1 = (Dealer) query.getSingleResult();
			return dealer1;


		}catch(Exception e) {
			e.printStackTrace();

		}finally {
			if(entityManager!= null) {
				entityManager.getTransaction().commit();
				entityManager.close();
			}
		}
		return dealer1;
	}

	@Override
	public boolean updateDealer(int dealerId, long dealerContactNo, String dealerLocation, String dealerName,
			String dealerPassword) {
		//Dealer dealer = new Dealer();
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		boolean state = false;
		try {
			entitymanager.getTransaction().begin();
			String jqpl="update Dealer s set s.dealerContactNo =:dealerContactNo ,"
					+ " s.dealerLocation=:dealerLocation, s.dealerName =:dealerName ,"
					+ " s.dealerPassword =:dealerPassword where dealerId=:dealerId ";
			Query query = entitymanager.createQuery(jqpl); 
			query.setParameter("dealerContactNo",dealerContactNo);
			query.setParameter("dealerLocation",dealerLocation);
			query.setParameter("dealerName",dealerName);
			query.setParameter("dealerPassword",dealerPassword);
			query.setParameter("dealerId",dealerId);
			int count=query.executeUpdate();

			entitymanager.getTransaction().commit();
			if(count>0) {
				state = true;
			}
		}catch(Exception e) {
			e.printStackTrace();

		}finally {
			if(entitymanager!= null) {
				entitymanager.close();
			}}

		return state;	
	}

	@Override
	public Dealer loginDealer(int dealerId, String dealerPassword) {
		Dealer dealer=null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			String jqpl="select u from Dealer u where u.dealerId =:dealerId  and u.dealerPassword=:dealerPassword";
			Query query = entityManager.createQuery(jqpl); 
			query.setParameter("dealerId", dealerId);
			query.setParameter("dealerPassword", dealerPassword);



			dealer=(Dealer) query.getSingleResult();

			entityManager.getTransaction().commit();
			return dealer;

		}catch(Exception e) {
			e.printStackTrace();

		}finally {
			if(entityManager!= null) {
				entityManager.close();
			}
		}

		return dealer;
	}

	@Override
	public boolean deleteDealer(int dealerId) {
		boolean state=false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try{
			entityManager.getTransaction().begin();

			String query="delete from Dealer  where dealerId=:dealerId";
			Query query1=entityManager.createQuery(query);
			query1.setParameter("dealerId", dealerId);
			int count=query1.executeUpdate();

			if(count>0)
			{
				state=true;

			}

		}
		catch(Exception e)
		{
			e.printStackTrace();

		}finally{
			if(entityManager!=null){
				entityManager.getTransaction().commit();
				entityManager.close();
			}
		}
		return state;
	}

	@Override
	public List<Dealer> listAll() {
		return null;
	}

	@Override
	public List<Dealer> getDealers() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Dealer> list = new ArrayList<Dealer>();
		try {
			entityManager.getTransaction().begin();
			String jqpl= "select b from Dealer b ";
			TypedQuery<Dealer> query = entityManager.createQuery(jqpl,Dealer.class); 

			list= query.getResultList();



		}catch(Exception e) {
			e.printStackTrace();

		}finally {
			if(entityManager!= null) {
				entityManager.getTransaction().commit();
				entityManager.close();
			}}
		return list;

	}
	}