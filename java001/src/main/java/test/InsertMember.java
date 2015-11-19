package test;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import regis.model.Member;
import regis.model.dao.MemberHibernateDAO;
import shoppingCart.model.dao.OrderHibernateDAO;

public class InsertMember {
	public static void main(String args[]) throws FileNotFoundException, SQLException {
		// test for save member
		// MemberHibernateDAO ch = new MemberHibernateDAO();
		// Member member = new Member(1, "111", "17.99", "0");
		// ch.save(member);
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		ProductHibernateDAO cc = new ProductHibernateDAO();
//
//		File file = new File("C:\\1.jpg");
//		long size = file.length();
//		InputStream is = new FileInputStream(file);
//		Blob sb = Hibernate.getLobCreator(session).
//				createBlob(is, size);
//		
//		Product product = new Product(1L, "死手錶", "該死", 
//				1111.00, 8, sb);
//		cc.save(product);

		
//		HQL04 hq = new HQL04();
//		hq.query4("select e.name, e.salary from Employee e");
//		HibernateUtil.close();
		
		
//		System.out.println(cc.checkIdPassword());
		
	
		
		
//		MemberHibernateDAO cc = new MemberHibernateDAO();
//		cc.selectMutiquery("select id , memberName ,memberPs from Member");

//		List<Member> ee = cc
//				.findMemPs("select memberPs from Member where memberName='micky'");
//		System.out.println(ee);
//		for (Member e : ee) {
//			System.out.printf("%2d %6s %6d %14s %2d\n", e.getId(),
//					e.getMemberName(), e.getmemberPs(), e.getmemberEmail());
//
//		}
		//	    for(Object[] anArray : dd){
//	        for(Object prop : anArray){
//	    	       System.out.print(prop + " ") ;
//	    	  }
//	    	  System.out.println();
//	    }
//		System.out.println(dd[0][1]);
		
		//看看我有幾個分頁test
		//ProductHibernateDAO aa = new ProductHibernateDAO();
//		System.out.println("多少？"+aa.getTotalPages());
//		System.out.println(aa.getAll());
		//[product.model.Product@6c0d9d86, product.model.Product@dbd8e44, product.model.Product@51acdf2e, product.model.Product@6a55299e, product.model.Product@2f1de2d6, product.model.Product@4eb386df, product.model.Product@79517588, product.model.Product@3a0baae5]
//		System.out.println("多少？"+aa.getPageBooks());
		//[product.model.Product@71812481, product.model.Product@3a0baae5, product.model.Product@7ac0e420, product.model.Product@289710d9, product.model.Product@5a18cd76, product.model.Product@3da30852]
		
		//測試getall排序方法
		//OrderHibernateDAO aa = new OrderHibernateDAO();
		//System.out.println(aa.getAllOrders());
		
		//測試getorder
		//OrderHibernateDAO bb = new OrderHibernateDAO();
		//System.out.println(bb.getOrder(2));
		
		//測試memberid
		MemberHibernateDAO aa = new MemberHibernateDAO();
		long tt = 2;
		Member aa1 = aa.findByPrimaryKey(tt);
		System.out.println(aa1.getMemberName());
	}

}
