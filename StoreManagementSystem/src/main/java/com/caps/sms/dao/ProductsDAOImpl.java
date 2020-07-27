package com.caps.sms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.caps.sms.beans.Products;


@Repository
public class ProductsDAOImpl implements ProductsDAO{
	
	@PersistenceUnit  
	EntityManagerFactory entitymanagerfactory ;


	@Override
	public boolean addProduct(Products product) {
	
			EntityManager entitymanager =  null ;
			boolean state= false;

			try{

				if(product!=null)
				{
					System.out.println("1");

					entitymanager = entitymanagerfactory.createEntityManager() ;
					entitymanager.getTransaction().begin();
					entitymanager.persist(product) ;
					System.out.println(" product added successfully ");
					state = true;
					return state;
				}

			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {


				entitymanager.getTransaction().commit();
				entitymanager.close();
			}
			return state;
		}
		


	@Override
	public Products getProduct(int productId) {
		
			EntityManager entitymanager = entitymanagerfactory.createEntityManager();
			Products Products =null ;
			try {
				entitymanager.getTransaction().begin();
				String jqpl= "select b from Products b where  b.productId=:productId";
				Query query = entitymanager.createQuery(jqpl); 
				query.setParameter("productId", productId);
				Products = (Products) query.getSingleResult();



				return Products;


			}catch(Exception e) {
				e.printStackTrace();

			}finally {
				if(entitymanager!= null) {
					entitymanager.getTransaction().commit();
					entitymanager.close();

				}



			}
			return Products;

		}

	@Override
	public boolean updateProduct(int manufacturerId, int productId, String productName, int productPrice, int productStock) {
		boolean state = false;
		EntityManager entityManager = entitymanagerfactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			String jqpl = "update Products s set s.manufacturerId =:manufacturerId ,"
					+ " s.productName=:productName, s.productPrice =:productPrice ,"
					+ " s.productStock =:productStock where productId=:productId ";


			Query query = entityManager.createQuery(jqpl); 
			query.setParameter("manufacturerId",manufacturerId);
			query.setParameter("productName",productName);
			query.setParameter("productPrice",productPrice);
			query.setParameter("productStock",productStock);
			query.setParameter("productId",productId);


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
	public boolean deleteProduct(int productId) {
		boolean state=false;
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();

		try{
			entitymanager.getTransaction().begin();

			String query="delete from Products  where productId=:productId";
			Query qu=entitymanager.createQuery(query);
			qu.setParameter("productId", productId);
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
	public int ProductPrice(int productId) {
		int price = -1;
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();

		try{
			entitymanager.getTransaction().begin();

			String query="select b.productPrice from Products b where  b.productId=:productId";
			Query qu=entitymanager.createQuery(query);
			qu.setParameter("productId", productId);
			price=(Integer)qu.getSingleResult();

			if(price>0)
			{
				return price ;

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
		return price;

	}


	@Override
	public List<Products> getProducts() {
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		List<Products> list = new ArrayList<Products>();
		try {
			entitymanager.getTransaction().begin();
			String jqpl= "select b from Products b ";
			TypedQuery<Products> query = entitymanager.createQuery(jqpl,Products.class); 

			list=query.getResultList();



		}catch(Exception e) {
			e.printStackTrace();

		}finally {
			if(entitymanager!= null) {
				entitymanager.getTransaction().commit();
				entitymanager.close();
			}}
		return list;
	
	}

}
