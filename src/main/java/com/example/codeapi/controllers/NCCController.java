package com.example.codeapi.controllers;
import com.example.codeapi.dto.PageNCC;
import com.example.codeapi.dto.PageUser;
import com.example.codeapi.dto.Request;
import com.example.codeapi.models.DMNCC;
import com.example.codeapi.serveice.DMNCC.NCCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DM_NCC")
@CrossOrigin(origins="http://localhost:4200")
public class NCCController {
    @Autowired
    private NCCService nccService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DMNCC save(@RequestBody DMNCC dmncc){
        return this.nccService.save(dmncc);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Request delete(@RequestBody DMNCC dmncc){ return this.nccService.delete(dmncc);}

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Request update(@RequestBody DMNCC dmncc){return this.nccService.update(dmncc);}

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public Request test(@RequestBody PageNCC pageNCC)
    {
        return  this.nccService.findByPagingCriteria(pageNCC);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<DMNCC> getAll(){
        return nccService.getAll();
    };
}
