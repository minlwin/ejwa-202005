package com.jdc.custom.model.repo;

import java.util.List;

import com.jdc.custom.model.BaseRepository;
import com.jdc.custom.model.entity.Item;

public interface ItemRepo extends BaseRepository<Item, Integer>{

	<T> List<T> findByBrend(String brend, Class<T> type);
}
