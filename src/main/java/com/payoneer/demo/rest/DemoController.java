package com.payoneer.demo.rest;

import com.payoneer.demo.impl.IngestService;
import com.payoneer.demo.impl.MessageRequest;
import com.payoneer.demo.impl.StatusMessage;
import com.payoneer.demo.impl.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class DemoController {

    @Autowired
    IngestService ingestService;

    @Autowired
    StatusService statusService;

    @RequestMapping(value ="/", method = RequestMethod.POST)
    public StatusMessage CreateMessage(@RequestBody MessageRequest request) {
        return ingestService.CreateMessage(request); }

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public StatusMessage getStatus(
            @RequestParam(value = "messageId") String messageId) {
        return statusService.getStatus(messageId); }
}
