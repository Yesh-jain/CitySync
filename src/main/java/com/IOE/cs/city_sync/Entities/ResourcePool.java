package com.IOE.cs.city_sync.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "RESOURCE_POOL")
public class ResourcePool {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RESOURCE" , referencedColumnName = "id")
	private Resource resource;

	@Column(name = "POOLED_QUANTITY")
	private Integer pooledQuantity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SHARED_USER_ID" , referencedColumnName = "id")
	private CSUser sharedUser;

}

