package shoppingCart.model.dao;

import java.util.List;

import regis.model.Member;
import shoppingCart.model.OrderItem;

public interface OrderItemDAO {
	// 新增一筆記錄
	int save(OrderItem orderItem);

	Member findByPrimaryKey(long key);

	// 查詢所有紀錄
	List<Member> getAll();

	// 依鍵值刪除一筆紀錄
	int delete(long key);

	// 依鍵值修改一筆紀錄
	int update(Member member);

}
