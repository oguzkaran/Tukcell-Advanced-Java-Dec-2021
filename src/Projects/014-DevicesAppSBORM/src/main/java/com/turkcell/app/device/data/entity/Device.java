package com.turkcell.app.device.data.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "devices")
public class Device { //POJO
	@Id
	@Column(name = "device_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	@Column(nullable = false, length = 100)
	public String name;

	@Column(nullable = false, length = 15)
	public String host;

	@OneToMany(mappedBy = "device", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<PortInfo> ports;
	//...
}
