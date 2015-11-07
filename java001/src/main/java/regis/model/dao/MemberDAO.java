package regis.model.dao;

import java.util.List;

import regis.model.Member;

public interface MemberDAO {
	// 新增一筆記錄
	int save(Member member);

	// 依鍵值查詢一筆記錄
	Member  findByPrimaryKey(long key);

	// 查詢所有紀錄
	List<Member> getAll();

	// 依鍵值刪除一筆紀錄
	int delete(long key);

	// 依鍵值修改一筆紀錄
	int update(Member member);


	}

