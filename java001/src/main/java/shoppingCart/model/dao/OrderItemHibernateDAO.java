package shoppingCart.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import all.util.HibernateUtil;
import regis.model.Member;
import shoppingCart.model.OrderItem;

public class OrderItemHibernateDAO implements OrderItemDAO {

	public boolean isDup(String name) {
		boolean result = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from MemberBean where id=?");
			query.setString(0, name);
			List<Member> list = (List<Member>) query.list();
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

	public int save(OrderItem orderItem) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		int count = 0;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// fullTableName)
			//session.save(String.format("SET IDENTITY_INSERT %s ON",orderItem));
			session.save(orderItem);
			tx.commit();
			count = 1;
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			System.out.println("rollback");
		} finally {
			if (session != null)
				session.close();
		}
		// factory.close();
		// HibernateUtil.shutdown();
		return count;
	}

	public Member findByPrimaryKey(long key) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Member member = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			member = (Member) session.get(Member.class, key);
			System.out.println("member是  "+member);
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
		return member;
	}

	public List<Member> getAll() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		List<Member> list = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from Member"); // HQL
			list = (List<Member>) query.list();

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

	public int delete(long key) {
		int count = 0;
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Member member = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			member = new Member(key);
			System.out.println("key=" + key);
			session.delete(member);
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

	public int update(Member member) {
		int count = 0;
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.merge(member);
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

	// test
	static private List<String> memberIDList = null;

	public void checkid() {
		if (memberIDList == null) {
			memberIDList = new ArrayList<>();
			populateIDList();
		}
	}

	public void populateIDList() {
		List<?> list = null;
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			list = session.createQuery("from Member").list();
			// System.out.println(list);
			for (Object o : list) {
				Member mem = (Member) o;
				String id = mem.getMemberName();
				memberIDList.add(id);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
	}

	public boolean idExists(String id) {
		boolean exist = false;
		for (String s : memberIDList) {
			if (s.equals(id.trim())) {
				exist = true;
				// System.out.println(s);

				break;
			}
		}
		return exist;
	}

	// public String findPassword(){
	//
	// }

	public List<Object[]> selectMutiquery(String hql) {
		List<Object[]> list = null;
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			list = session.createQuery(hql).list();
			// System.out.println(list);
			for (Object[] anArray : list) {
				for (Object prop : anArray) {
					System.out.print(prop + " ");
				}
				System.out.println();
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		return list;
	}

	public List<Member> findMemPs(String hql) {
		List<Member> list = null;
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			list = session.createQuery(hql).list();
//			for (Member e : list) {
//				System.out.printf("%2d %6s %6d %14s %2d\n", e.getId(),
//						e.getMemberName(), e.getmemberPs(), e.getmemberEmail());
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
