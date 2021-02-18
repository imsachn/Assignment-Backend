package com.hashedin.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service")
@Data
@EqualsAndHashCode(callSuper = true)
public class Service extends BaseEntity {
		@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id", updatable =false ,nullable = false)
	    private Integer id;

		@Column(name = "service_name")
		private String serviceName;

}
