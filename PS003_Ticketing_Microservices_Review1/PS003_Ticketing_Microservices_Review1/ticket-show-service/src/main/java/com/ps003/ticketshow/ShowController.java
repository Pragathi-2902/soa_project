package com.ps003.ticketshow;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shows")
public class ShowController {


    @GetMapping
    public String getShows() {
        return "Show Service: 10:00 AM, 2:00 PM, 6:00 PM";
    }

    @GetMapping("/{id}")
    public String getShow(@PathVariable int id) {
        return "Show Service: Show ID = " + id;
    }

    @PostMapping
    public String addShow(@RequestBody String show) {
        return "Show added successfully: " + show;
    }

}
