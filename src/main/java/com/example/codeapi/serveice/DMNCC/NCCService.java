package com.example.codeapi.serveice.DMNCC;

import com.example.codeapi.dto.PageNCC;
import com.example.codeapi.dto.PageUser;
import com.example.codeapi.dto.Request;
import com.example.codeapi.models.DMNCC;
import com.example.codeapi.models.User;

import java.util.List;

public interface NCCService {
    DMNCC save(DMNCC dmncc);
    List<DMNCC> findAll();
    Request<?> delete(DMNCC dmnc);

    Request update(DMNCC dmncc);

    Request findByPagingCriteria(PageNCC pageNCC);
}
