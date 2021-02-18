
package com.hashedin.web;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@ToString
@Builder
public class APIResponseModel {

	boolean success;
	String message;
	Object body;
	
	
	public static APIResponseModel errorAPIResponseModel(String message) {
		APIResponseModel apiResponseModel = new APIResponseModel();
		apiResponseModel.setSuccess(false);
		apiResponseModel.setMessage(message);
		return apiResponseModel;
		
	}

	public static APIResponseModel successAPIResponseModel(String message) {
		APIResponseModel apiResponseModel = new APIResponseModel();
		apiResponseModel.setSuccess(true);
		apiResponseModel.setMessage(message);
		return apiResponseModel;
		
	}

	
	
	
}
