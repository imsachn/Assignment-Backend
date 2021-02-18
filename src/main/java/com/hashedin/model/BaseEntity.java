package com.hashedin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import com.hashedin.utils.DateUtils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@FieldDefaults(level=AccessLevel.PRIVATE)
public class BaseEntity {
	
	@Column(columnDefinition ="datetime default now()")
	Date zCreated;

	@Column(columnDefinition ="datetime default now()")
	Date zUpdated;
	
	@PrePersist
	protected void onCreate() {
		zCreated =DateUtils.istDate();
		zUpdated =DateUtils.istDate();
	}
	

}
