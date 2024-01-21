package com.oracle.assignment.restapi.controller;

import com.oracle.assignment.restapi.model.SampleServiceRequest;
import com.oracle.assignment.restapi.model.SampleServiceResponse;
import com.oracle.assignment.restapi.model.SampleServiceRq;
import com.oracle.assignment.restapi.model.SampleServiceRs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleServiceController {

    @PostMapping("/external/services/rest/sample-service")
    public ResponseEntity<SampleServiceResponse> doSampleService(@RequestBody SampleServiceRequest request){
        SampleServiceResponse response = execute(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private SampleServiceResponse execute(SampleServiceRequest sampleServiceRequest){
        SampleServiceRq sampleServiceRq = sampleServiceRequest.getSampleServiceRq();

        return SampleServiceResponse.builder()
                .sampleServiceRs(
                        SampleServiceRs.builder()
                                .errorCode("0000")
                                .errorMsg("Success")
                                .trxId(sampleServiceRq.getTrxId())
                                .build()
                )
                .build();
    }
}
