package fts.intern.hotelmanager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fts.intern.hotelmanager.model.Hotel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.util.List;


@SpringBootApplication
public class HotelmanagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(HotelmanagerApplication.class, args);



//		ObjectMapper mapper = new ObjectMapper();
//		TypeReference<List<Hotel>> typeReference = new TypeReference<List<Hotel>>(){};
//		InputStream inputStream = TypeReference.class.getResourceAsStream("/hotels.json");
//		try {
//			List<Hotel> hotels = mapper.readValue(inputStream, typeReference);
//			System.out.println("Hotels Saved!");
//		} catch (Exception e){
//			System.out.println("Unable to save hotels: " + e.getMessage());
//		}
	}

}
