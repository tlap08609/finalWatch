package shoppingCart.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import product.model.OrderItemBean;
import shoppingCart.model.Order;
import shoppingCart.model.OrderItem;
import all.util.HibernateUtil;

public class OrderHibernateDAO implements OrderDAO {
	//private DataSource ds = null;
//	public boolean isDup(String name) {
//		boolean result = false;
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			Query query = session.createQuery("from MemberBean where id=?");
//			query.setString(0, name);
//			List<Member> list = (List<Member>) query.list();
//			if (list.isEmpty()) {
//				result = false;
//			} else {
//				result = true;
//			}
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null)
//				tx.rollback();
//			System.out.println(ex.getMessage());
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		return result;
//	}
	
//	public void insertOrder(Order ob) throws SQLException {
//		
//		String sqlOrder = "Insert Into java001_order "
//				+ " (userID, totalAmount, shippingAddress, BNO, InvoiceTitle, orderDate) "
//				+ " values(?, ?, ?, ?, ?, ?) ";
//		Connection conn = null;
//		PreparedStatement pStmt = null;
//		ResultSet generatedKeys = null;
//		PreparedStatement pStmt2 = null;
//		try {
//			conn = ds.getConnection();
//			conn.setAutoCommit(false);  // 開啟JDBC Transaction
//			pStmt = conn.prepareStatement(sqlOrder,
//					Statement.RETURN_GENERATED_KEYS);
//			pStmt.setString(1, ob.getUserId());
//			pStmt.setDouble(2, ob.getTotalAmount());
//			pStmt.setString(3, ob.getShippingAddress());
//			pStmt.setString(4, ob.getBno());
//			pStmt.setString(5, ob.getInvoiceTitle());
//			Timestamp ts = new Timestamp(ob.getOrderDate().getTime());
//			pStmt.setTimestamp(6, ts);
//			pStmt.executeUpdate();
//			int id = 0;
//			generatedKeys = pStmt.getGeneratedKeys();
//			if (generatedKeys.next()) {
//				id = generatedKeys.getInt(1);
//			} else {
//				throw new SQLException(
//						"Creating user failed, no generated key obtained.");
//			}
//			String sqlItem = "Insert Into OrderItems (orderNo, bookID, description, amount, unitPrice, discount) "
//					+ " values(?, ?, ?, ?, ?) ";
//			List<OrderItem> items = ob.getItems();
//			pStmt2 = conn.prepareStatement(sqlItem);
//			int n=0;
//			for (OrderItem oib : items) {
////              下列四個敘述為交易測試而編寫	
////				n++;
////				if (n > 2) {
////					System.out.println("發生例外 n>2");
////					throw new SQLException("JDBC交易測試用");
////				}
//				pStmt2.setInt(1, id);
//				pStmt2.setInt(2, oib.getProductNo());
//				pStmt2.setString(3, oib.getDescription());
//				pStmt2.setDouble(4, oib.getAmount());
//				pStmt2.setDouble(5, oib.getUnitPrice());
//				int count = pStmt2.executeUpdate();
//				pStmt2.clearParameters();
//			}
//			conn.commit();  
//		} catch(SQLException ex){
//			System.out.println("資料還原");
//			if(conn!=null) conn.rollback();
//		} finally {
//			
//			if (pStmt != null) {
//				pStmt.close();
//			}
//			if (pStmt2 != null) {
//				pStmt2.close();
//			}
//			if(conn!=null)  conn.setAutoCommit(true);
//			if (conn != null) {
//				conn.close();
//			}
//		}
//	}
	
	
	
	
	
	
	
	
	

	public int save(Order order) {
//		   int save(Order order)
		SessionFactory factory = HibernateUtil.getSessionFactory();
		int count = 0;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(order);
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

//	public Member findByPrimaryKey(long key) {
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Member member = null;
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			member = (Member) session.get(Member.class, key);
//			System.out.println("member是  "+member);
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null)
//				tx.rollback();
//			ex.printStackTrace();
//		} finally {
//			if (session != null)
//				session.close();
//		}
//		// factory.close();
//		return member;
//	}

	public List<Order> getAll() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		List<Order> list = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from Order"); // HQL
			list = (List<Order>) query.list();

			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			System.out.println(ex.getMessage());
		}
		return list;
	}

	// public List<Member> checkIdPassword() {
	// SessionFactory factory = HibernateUtil.getSessionFactory();
	// Session session = factory.openSession();
	// Transaction tx = null;
	// List<Member> list = null;
	// try {
	// tx = session.beginTransaction();
	// Query query = session.createQuery("from Member"); // HQL
	// list = (List<Member>)query.list();
	// for (Member e : list) {
	// System.out.println("-----"+ e.getMemberName()+
	// e.getmemberPs());
	// }
	// tx.commit();
	// } catch(Exception ex){
	// if (tx != null) tx.rollback();
	// System.out.println(ex.getMessage());
	// }
	// return list;
	// }

//	public int delete(long key) {
//		int count = 0;
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Member member = null;
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			member = new Member(key);
//			System.out.println("key=" + key);
//			session.delete(member);
//			tx.commit();
//			count = 1;
//		} catch (Exception ex) {
//			if (tx != null)
//				tx.rollback();
//			ex.printStackTrace();
//		} finally {
//			if (session != null)
//				session.close();
//		}
//		// factory.close();
//
//		return count;
//	}

//	public int update(Member member) {
//		int count = 0;
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			session.merge(member);
//			tx.commit();
//			count = 1;
//		} catch (Exception ex) {
//			if (tx != null)
//				tx.rollback();
//			ex.printStackTrace();
//		} finally {
//			if (session != null)
//				session.close();
//		}
//		// factory.close();
//
//		return count;
//
//	}

	// test
//	static private List<String> memberIDList = null;
//
//	public void checkid() {
//		if (memberIDList == null) {
//			memberIDList = new ArrayList<>();
//			populateIDList();
//		}
//	}
//
//	public void populateIDList() {
//		List<?> list = null;
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			list = session.createQuery("from Member").list();
//			// System.out.println(list);
//			for (Object o : list) {
//				Member mem = (Member) o;
//				String id = mem.getMemberName();
//				memberIDList.add(id);
//			}
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
//			System.out.println(e.getMessage());
//		}
//	}
//
//	public boolean idExists(String id) {
//		boolean exist = false;
//		for (String s : memberIDList) {
//			if (s.equals(id.trim())) {
//				exist = true;
//				// System.out.println(s);
//
//				break;
//			}
//		}
//		return exist;
//	}
//
//	// public String findPassword(){
//	//
//	// }
//
//	public List<Object[]> selectMutiquery(String hql) {
//		List<Object[]> list = null;
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			list = session.createQuery(hql).list();
//			// System.out.println(list);
//			for (Object[] anArray : list) {
//				for (Object prop : anArray) {
//					System.out.print(prop + " ");
//				}
//				System.out.println();
//			}
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
//			System.out.println(e.getMessage());
//		}
//		return list;
//	}
//
//	public List<Member> findMemPs(String hql) {
//		List<Member> list = null;
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			list = session.createQuery(hql).list();
////			for (Member e : list) {
////				System.out.printf("%2d %6s %6d %14s %2d\n", e.getId(),
////						e.getMemberName(), e.getmemberPs(), e.getmemberEmail());
////
////			}
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
//			System.out.println(e.getMessage());
//		}
//
//		return list;
//	}



}
