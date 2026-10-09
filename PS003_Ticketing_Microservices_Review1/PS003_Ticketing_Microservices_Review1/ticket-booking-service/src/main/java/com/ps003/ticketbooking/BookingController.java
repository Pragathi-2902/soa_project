package com.ps003.ticketbooking;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {


    @GetMapping
    public String getBookings() {
        return "Booking Service: No database yet - Review 1 demo endpoint";
    }

    @PostMapping
    public String bookTicket(@RequestBody String booking) {
        return "Ticket booking request received: " + booking;
    }

}