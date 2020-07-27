package com.caps.sms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.caps.sms.beans.Manufacturer;
@Repository
public class ManufacturerDAOImpl implements ManufacturerDAO{

	@PersistenceUnit  
	EntityManagerFactory entityManagerFactory ;
	
	@Override
	public boolean addManufacturer(Manufacturer manufacturer) {
		EntityManager entityManager =  null;
		boolean state = false;
		try
		{
			if(manufacturer != null)
			{
				entityManager = entityManagerFactory.createEntityManager() ;
				entityManager.getTransaction().begin();
				entityManager.persist(manufacturer) ;
				state = true;
				return state;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(entityManager!= null) {
			entityManager.getTransaction().commit();
			entityManager.close();
		}
		}
		return state ;
	}

	@Override
	public Manufacturer getManufacturer(int manufacturerId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Manufacturer manufacture =null ;
		try {
			entityManager.getTransaction().begin();
			String jqpl= "select b from Manufacturer b where  b.manufacturerId=:manufacturerId";
			Query query = entityManager.createQuery(jqpl); 
			query.setParameter("manufacturerId", manufacturerId);
			Manufacturer manufacturer = (Manufacturer) query.getSingleResult();
			return manufacturer;
		}catch(Exception e) {
			e.printStackTrace();

		}finally {
			if(entityManager!= null) {
				entityManager.getTransaction().commit();
				entityManager.close();
			}
		}
		return manufacture;
	}

	@Override
	public boolean updateManufacturer(int manufacturerId, long manufacturerContactNo, String manufacturerLocation,
			String manufacturerName, String manufacturerPassword) {
		Manufacturer manufacturer = new Manufacturer();
		boolean state = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			String jqpl="update Manufacturer s set s.manufacturerContactNo =:manufacturerContactNo ,"
					+ " s.manufacturerLocation=:manufacturerLocation,"
					+ " s.manufacturerName =:manufacturerName ,"
					+ "s.manufacturerPassword =:manufacturerPassword where manufacturerId=:manufacturerId ";
			Query query = entityManager.createQuery(jqpl); 
			query.setParameter("manufacturerContactNo",manufacturerContactNo);
			query.setParameter("manufacturerLocation",manufacturerLocation);
			query.setParameter("manufacturerName",manufacturerName);
			query.setParameter("manufacturerPassword",manufacturerPassword);
			query.setParameter("manufacturerId",manufacturerId);
			int count=query.executeUpdate();

			entityManager.getTransaction().commit();
			if(count>0) {
				state = true;
			}
		}catch(Exception e) {
			e.printStackTrace();

		}finally {
			if(entityManager!= null) {
				entityManager.close();
			}}

		return state;	


	}

	@Override
	public Manufacturer loginManufacturer(int manufacturerId, String manufacturerPassword) {
		Manufacturer manufacturer=null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			String jqpl="select u from Manufacturer u where"
					+ " u.manufacturerId =:manufacturerId "
					+ " and u.manufacturerPassword=:manufacturerPassword";

			Query query = entityManager.createQuery(jqpl); 
			query.setParameter("manufacturerId", manufacturerId);
			query.setParameter("manufacturerPassword", manufacturerPassword);
			manufacturer=(Manufacturer) query.getSingleResult();

			entityManager.getTransaction().commit();
			return manufacturer;

		}catch(Exception e) {
			e.printStackTrace();

		}finally {
			if(entityManager!= null) {
				entityManager.close();
			}
		}

		return manufacturer;
	}

	@Override
	public boolean deleteManufacturer(int manufacturerId) {

		boolean state=false;
		EntityManager entitymanager = entityManagerFactory.createEntityManager();

		try{
			entitymanager.getTransaction().begin();

			String query="delete from Manufacturer  where manufacturerId=:manufacturerId";
			Query qu=entitymanager.createQuery(query);
			qu.setParameter("manufacturerId", manufacturerId);
			int count=qu.executeUpdate();

			if(count>0)
			{
				state=true;

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}finally{
			if(entitymanager!=null){
				entitymanager.getTransaction().commit();
				entitymanager.close();
			}
		}
		return state;
	}

	@Override
	public List<Manufacturer> listAll() {

		List<Manufacturer> manufacturer = new ArrayList<>();

		return manufacturer;
	}

	@Override
	public List<Manufacturer> getManufacturers() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Manufacturer> list = new ArrayList<Manufacturer>();
		try {
			entityManager.getTransaction().begin();
			String jqpl= "select b from Manufacturer b ";
			TypedQuery<Manufacturer> query = entityManager.createQuery(jqpl,Manufacturer.class); 

			list=query.getResultList();



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
