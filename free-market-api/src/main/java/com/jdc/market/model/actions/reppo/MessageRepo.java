package com.jdc.market.model.actions.reppo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.market.model.actions.entity.Messages;

public interface MessageRepo extends JpaRepository<Messages, UUID>{

}
