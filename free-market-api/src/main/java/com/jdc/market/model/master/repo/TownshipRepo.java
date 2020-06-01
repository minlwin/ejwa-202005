package com.jdc.market.model.master.repo;

import java.util.List;

import com.jdc.market.model.BaseRepository;
import com.jdc.market.model.master.entity.Township;

public interface TownshipRepo extends BaseRepository<Township, Integer>{

	List<Township> findByRegionId(int region);
}
