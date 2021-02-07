package com.example.armstest.xlsx;

import com.example.armstest.Demand;
import com.example.armstest.data.DemandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/demand")
public class DownloadExcel {
    private DemandRepo demandRepo;
    @Autowired
    public DownloadExcel(DemandRepo demandRepo) {
        this.demandRepo = demandRepo;
    }
    @GetMapping(value = "/download/demand.xlsx")
    public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
        List<Demand> demand = (List<Demand>) demandRepo.findAll();

        ByteArrayInputStream in = ExcelGeneration.demandExcel(demand);
        // return IOUtils.toByteArray(in);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=demand.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
}
