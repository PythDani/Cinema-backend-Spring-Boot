package co.com.qvision.cinema.controllers;

import java.io.IOException;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;



public class JsonUtil {
	public static byte[] toJson(Object object) throws IOException {
		
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    return mapper.writeValueAsBytes(object);
	    }
	}


