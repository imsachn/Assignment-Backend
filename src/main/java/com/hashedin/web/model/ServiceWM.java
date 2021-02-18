package com.hashedin.web.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class ServiceWM {

	Integer id;
	String serviceName;
	String env;
	String technology;
	String version;
	String gitbrach;
	Date created;
	Date updated;
	String username;

}
