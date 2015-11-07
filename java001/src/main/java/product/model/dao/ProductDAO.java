package product.model.dao;

import java.util.List;

import product.model.Product;

public interface ProductDAO {
	// 新增一筆記錄
	int save(Product product);

	// 依鍵值查詢一筆記錄
	Product  findByPrimaryKey(long key);

	// 查詢所有紀錄
	List<Product> getAll();

	// 依鍵值刪除一筆紀錄
	int delete(long key);

	// 依鍵值修改一筆紀錄
	int update(Product product);


	}

