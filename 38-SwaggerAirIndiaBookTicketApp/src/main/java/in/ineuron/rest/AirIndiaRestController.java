package in.ineuron.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.request.PassangerInfo;
import in.ineuron.response.TicketInfo;

@RestController
public class AirIndiaRestController {
	
	@PostMapping("/bookFlightTicket")
	public ResponseEntity<TicketInfo> bookTicket(@RequestBody PassangerInfo pInfo){
		
		TicketInfo tInfo=new TicketInfo();
		tInfo.setName(pInfo.getFname()+" "+pInfo.getLname());
		tInfo.setFrom(pInfo.getFrom());
		tInfo.setTo(pInfo.getTo());
		tInfo.setJourneyDate("15-09-2023");
		tInfo.setTicketPrice("2500.00 INR");
		tInfo.setTicketStatus("CONFIRMED");
		
		return new ResponseEntity<>(tInfo, HttpStatus.CREATED);
	}

}
