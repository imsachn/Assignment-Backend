
package com.hashedin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="deployment")
public class Deployment extends BaseEntity {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id", updatable =false ,nullable = false)
	    private int id;

		@ManyToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="service_id")
		@ToString.Exclude
		@EqualsAndHashCode.Exclude
		private Service service;
	    
	    @Column(name = "environment", nullable = false)
	    private String environment;
	    
	    @Column(name = "username", nullable = false)
	    private String username;
	    
	    @Column(name = "version", nullable = false)
	    private String version;
	    
	    @Column(name = "gitbranch", nullable = false)
	    private String gitbranch;
	    
	    @Column(name = "technology", nullable = false)
	    private String technology;
	
		
}
