package com.poc.export.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.export.entity.DBFile;

@Repository
public interface ExportRepository extends JpaRepository<DBFile, Long> {

}
