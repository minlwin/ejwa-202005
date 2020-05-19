package com.jdc.mapping;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mapping.entity.State;
import com.jdc.mapping.entity.Township;
import com.jdc.mapping.repo.StateRepo;
import com.jdc.mapping.repo.TownshipRepo;

@SpringBootTest
class TownshipTest {
	
	@Autowired
	private TownshipRepo townships;
	@Autowired
	private StateRepo states;

	@Test
	void createTownshipTest() {
		
		Township ts = new Township();
		ts.setName("Kamayut");
		
		State st = new State();
		st.setName("Yangon");
		
//		states.save(st);
		
		ts.setState(st);
		
		townships.save(ts);
		
		assertEquals(1, ts.getId());
		assertEquals(1, st.getId());
	}

}
