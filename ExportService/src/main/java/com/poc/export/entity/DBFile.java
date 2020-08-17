package com.poc.export.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "files")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DBFile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String fileName;

	private String fileType;

	@Lob
	private byte[] data;

}