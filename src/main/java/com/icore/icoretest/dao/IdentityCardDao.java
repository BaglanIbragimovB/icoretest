package com.icore.icoretest.dao;

import com.icore.icoretest.entity.IdentityCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentityCardDao extends JpaRepository<IdentityCard, Long> {
}