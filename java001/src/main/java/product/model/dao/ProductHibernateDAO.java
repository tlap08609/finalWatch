package product.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import product.model.Product;
import regis.model.Member;
import all.util.HibernateUtil;

public class ProductHibernateDAO implements ProductDAO {
	private int totalPages = -1;
//	int pageNo = 0;
	public static int pageNo = 0;
	public static int recordsPerPage = 6; // 每頁六筆

	public boolean isDup(String name) {
		boolean result = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from ProductBean where id=?");
			query.setString(0, name);
			List<Product> list = (List<Product>) query.list();
			if (list.isEmpty()) {
				result = false;
			} else {
				result = true;
			}
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			System.out.println(ex.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public int save(Product product) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		int count = 0;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(product);
			tx.commit();
			count = 1;
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		// factory.close();
		// HibernateUtil.shutdown();
		return count;
	}

	public Product findByPrimaryKey(long key) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Product product = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			product = (Product) session.get(Product.class, key);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		// factory.close();
		return product;
	}

	public List<Product> getAll() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		List<Product> list = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from Product"); // HQL
			list = (List<Product>) query.list();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			System.out.println(ex.getMessage());
		}
		return list;
	}

	public int delete(long key) {
		int count = 0;
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Product product = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			product = new Product(key);
			System.out.println("key=" + key);
			session.delete(product);
			tx.commit();
			count = 1;
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		// factory.close();

		return count;
	}

	public int update(Product product) {
		int count = 0;
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.merge(product);
			tx.commit();
			count = 1;
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		// factory.close();

		return count;

	}
	public int getTotalPages() throws SQLException {
		// 計算總共有幾頁
		if (totalPages == -1) {
			// 注意下一列的double型態轉換
			totalPages = (int) (Math.ceil(getRecordCounts()
					/ (double) recordsPerPage));
		}
		return totalPages;
	}
	
//	public int getPageNo() {
//		return pageNo;
//	}
//
//	public int setPageNo(int pageNo) {
//		return this.pageNo = pageNo;
//	}
//	public int getRecordsPerPage() {
//		return recordsPerPage;
//	}
//
//	public void setRecordsPerPage(int recordsPerPage) {
//		this.recordsPerPage = recordsPerPage;
//	}
	
	
	
	public long getRecordCounts() throws SQLException {
		long countsResult = 0;
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session
		            .createQuery("SELECT count(*) FROM Product");
			countsResult = (long) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		return countsResult;
	}
	public List<Product> getPageBooks() {
		
		List<Product> list = null;
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from Product");
//			select rownum from Product where rownum >= ? and  rownum <= ?
//			query.setLong(0, 9);
//			query.setLong(1, 14);
			int startRecordNo = (pageNo - 1) * recordsPerPage ;
			int endRecordNo = (pageNo) * recordsPerPage;
			query.setFirstResult(startRecordNo);
			query.setMaxResults(endRecordNo);
//			query.setFirstResult(0);
//			query.setMaxResults(6);
			list = query.list();
//			for (Product e : list) {
//				System.out.printf("%2d %6s %6d %14s %2d\n", e.getproductNo(),
//						e.getproductName(), e.getproductContent(), e.getproductPrice() , e.getproductStock());
//
//			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}

		return list;
	}
}
