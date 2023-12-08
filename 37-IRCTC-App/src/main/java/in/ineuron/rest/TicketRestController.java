package in.ineuron.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.binding.PassangerInfo;
import in.ineuron.binding.TicketInfo;

@RestController
public class TicketRestController {

	@GetMapping("/ticket{ticketId}")
	public ResponseEntity<TicketInfo> getTicket(@PathVariable("ticketId") Integer ticketId) {
		//	logic to get ticket
		TicketInfo tInfo = new TicketInfo();
		tInfo.setTicketId(ticketId);
		tInfo.setPnr("ABCD1235");
		tInfo.setStatus("Confirmed");
		return new ResponseEntity<>(tInfo, HttpStatus.OK);
	}
	@PostMapping(value = "/ticket", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<TicketInfo> getTicket(@RequestBody PassangerInfo request) {

		System.out.println(request);
		TicketInfo tInfo = new TicketInfo();
		tInfo.setTrainNo(112233);
		tInfo.setPnr("ABCD1235");
		tInfo.setStatus("Confirmed");
		return new ResponseEntity<TicketInfo>(tInfo, HttpStatus.CREATED);
	}
	@PutMapping("/ticket")
	public ResponseEntity<String> updateTicket(@RequestBody PassangerInfo request) {
		System.out.println(request);
		return new ResponseEntity<String>("Ticket Updated", HttpStatus.OK);
	}

	@DeleteMapping("/ticket{ticketId}")
	public ResponseEntity<String> deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		//	logic to delete ticket
		return new ResponseEntity<String>("Ticket deleted", HttpStatus.OK);
	}
}
