package board.model.dao;

import java.util.List;

import board.model.Board;
import product.model.Product;

public interface BoardDAO {
	// 新增一筆記錄
	void save(Board board);

	// 依鍵值查詢一筆記錄
	Board  findByPrimaryKey(int key);

	// 查詢所有紀錄
	List<Board> getAll();

	// 依鍵值刪除一筆紀錄
	int delete(int key);

	// 依鍵值修改一筆紀錄
	int update(Board board);

}

