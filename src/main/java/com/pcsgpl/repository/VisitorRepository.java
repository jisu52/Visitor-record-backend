package com.pcsgpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pcsgpl.entity.Visitor;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Integer>{
//	public Visitor getVisitorById(int id);
}
