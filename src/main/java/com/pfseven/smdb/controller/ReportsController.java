package com.pfseven.smdb.controller;

import com.pfseven.smdb.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportsController extends AbstractController {

    @Override
    protected BaseService getService() {
        return null;
    }


}
