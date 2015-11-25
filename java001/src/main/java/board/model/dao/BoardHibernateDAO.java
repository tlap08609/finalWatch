package board.model.dao;

import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import board.model.Board;
import all.util.HibernateUtil;

public class BoardHibernateDAO implements BoardDAO {
	private int totalPages = -1;
	// int pageNo = 0;
	public static int pageNo = 0;
	public static int recordsPerPage = 6; // 每頁六筆

	public void save(Board bb) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		String m = bb.getMainText();
		Clob clob = null;
		try {
			tx = session.beginTransaction();
			clob = Hibernate.getLobCreator(session).createClob(m);
			bb.setComment(clob);
			session.save(bb);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}

	}
	public List<Board> getAllBoards() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Board>  list = null;
		try {
			tx = session.beginTransaction();
			String hql = "from Board b order by b.no desc";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
		} catch(Exception ex){
			//ex.printStackTrace();
			if (ex != null) tx.rollback();
			System.out.println(ex.getMessage());
		}
		return list;
	}

	public Board findByPrimaryKey(int key) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Board board = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			board = (Board) session.get(Board.class, key);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		/*
		 * finally { if (session != null) session.close(); }
		 */
		// factory.close();
		return board;
	}

	public Board getBoard(int pk) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		Board bb = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bb = (Board) session.get(Board.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		}
		return bb;
	}

	public List<Board> getAll() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		List<Board> list = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from Board"); // HQL
			list = (List<Board>) query.list();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			System.out.println(ex.getMessage());
		}
		return list;
	}

	public int delete(int no) {
		int count = 0;
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Board board = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			board = new Board(no);
			session.delete(board);
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

	public int update(Board board) {
		int count = 0;
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.merge(board);
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

	// public int getPageNo() {
	// return pageNo;
	// }
	//
	// public int setPageNo(int pageNo) {
	// return this.pageNo = pageNo;
	// }
	// public int getRecordsPerPage() {
	// return recordsPerPage;
	// }
	//
	// public void setRecordsPerPage(int recordsPerPage) {
	// this.recordsPerPage = recordsPerPage;
	// }

	public long getRecordCounts() throws SQLException {
		long countsResult = 0;
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("SELECT count(*) FROM Product");
			countsResult = (long) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		return countsResult;
	}

	public List<Board> getPageBooks() {

		List<Board> list = null;
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from Board");
			// select rownum from Product where rownum >= ? and rownum <= ?
			// query.setLong(0, 9);
			// query.setLong(1, 14);
			int startRecordNo = (pageNo - 1) * recordsPerPage;
			int endRecordNo = (pageNo) * recordsPerPage;
			query.setFirstResult(startRecordNo);
			query.setMaxResults(endRecordNo);
			// query.setFirstResult(0);
			// query.setMaxResults(6);
			list = query.list();
			// for (Product e : list) {
			// System.out.printf("%2d %6s %6d %14s %2d\n", e.getproductNo(),
			// e.getproductName(), e.getproductContent(), e.getproductPrice() ,
			// e.getproductStock());
			//
			// }
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}

		return list;
	}

	public List<Board> queryProduct(String word) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		List<Board> list = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Board b WHERE b.comment like :word";
			Query query = session.createQuery(hql);
			query.setParameter("word", "%" + word + "%");
			list = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return list;
	}

}
