package com.example.codeapi.serveice.DMNCC;

import com.example.codeapi.Common.Constant;
import com.example.codeapi.dto.PageNCC;
import com.example.codeapi.dto.PageUser;
import com.example.codeapi.dto.Request;
import com.example.codeapi.models.DMNCC;
import com.example.codeapi.models.User;
import com.example.codeapi.repositories.NCCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NCCServiceImpl implements NCCService{


    @Autowired
    private NCCRepository nccRepositories;

    @Override
    public Request<?> delete(DMNCC dmnccDelete) {
        Optional<DMNCC> nccOptional = nccRepositories.findById(dmnccDelete.getID());
        try{
            if(nccOptional.isPresent())
            {
                DMNCC dmncc = nccOptional.get();
                nccRepositories.deleteById(dmnccDelete.getID());
                return new Request<DMNCC>(200, Constant.Success, dmncc);
            }
            return new Request<String>(400, Constant.BadRequest, Constant.DataID);
        }catch (Exception e){
            return new Request<String>(400, Constant.BadRequest, e.getMessage());
        }
    }

    @Override
    public Request update(DMNCC dmnccNew) {
        Optional<DMNCC> dmnccOptional = nccRepositories.findById(dmnccNew.getID());
        try{
            if(dmnccOptional.isPresent())
            {
                DMNCC dmnccOld = dmnccOptional.get();
                if(dmnccNew.getTenNgan() != null)
                {
                    dmnccOld.setTenNgan(dmnccNew.getTenNgan());
                }
                if(dmnccNew.getTenDayDu() != null)
                {
                    dmnccOld.setTenDayDu(dmnccNew.getTenDayDu());
                }
                if(dmnccNew.getDiaChiGD() != null)
                {
                    dmnccOld.setDiaChiGD(dmnccNew.getDiaChiGD());
                }
                if(dmnccNew.getDiaChiTT() != null)
                {
                    dmnccOld.setDiaChiTT(dmnccNew.getDiaChiTT());
                }
                if(dmnccNew.getLienHeAM() != null)
                {
                    dmnccOld.setLienHeAM(dmnccNew.getLienHeAM());
                }
                if(dmnccNew.getLienHeTD() != null)
                {
                    dmnccOld.setLienHeTD(dmnccNew.getLienHeTD());
                }
                if(dmnccNew.getLienHeKT() != null)
                {
                    dmnccOld.setLienHeKT(dmnccNew.getLienHeKT());
                }
                if(dmnccNew.getNgayTao() != null)
                {
                    dmnccOld.setNgayTao(dmnccNew.getNgayTao());
                }
                if(dmnccNew.getNgaySua() != null)
                {
                    dmnccOld.setNgaySua(dmnccNew.getNgaySua());
                }
                if(dmnccNew.getNguoiTao() != null)
                {
                    dmnccOld.setNguoiTao(dmnccNew.getNguoiTao());
                }
                if(dmnccNew.getNguoiSua() != null)
                {
                    dmnccOld.setNguoiSua(dmnccNew.getNguoiSua());
                }
                if(dmnccNew.getMa() != null)
                {
                    dmnccOld.setMa(dmnccNew.getMa());
                }
                if(dmnccNew.getMaSoThue() != null)
                {
                    dmnccOld.setMaSoThue(dmnccNew.getMaSoThue());
                }
                nccRepositories.save(dmnccOld);
                return new Request<DMNCC>(200, Constant.Success, dmnccOld);
            }
            return new Request<String>(400, Constant.BadRequest, Constant.DataID);
        }catch(Exception e)
        {
            return new Request<String>(200, Constant.Success, e.getMessage());
        }
    }

    @Override
    public Request findByPagingCriteria(PageNCC pageNCC) {
        Pageable pageable = PageRequest.of(pageNCC.getPageDto().getPageNo(),pageNCC.getPageDto().getPageSize());
        try{
            Page page = nccRepositories.findAll(new Specification<DMNCC>() {
                @Override
                public Predicate toPredicate(Root<DMNCC> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    List<Predicate> predicates = new ArrayList<>();
                    if(pageNCC.getDmncc().getTenNgan() != null )
                    {
                        predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("username"), "%"+pageNCC.getDmncc().getTenNgan() +"%")));
                    }

                    if(pageNCC.getDmncc().getTenDayDu() != null )
                    {
                        predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("password"), "%"+pageNCC.getDmncc().getTenDayDu() +"%")));
                    }

                    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                }

            }, pageable);
            List<User> listUser = page.getContent();
            return new Request<Page<User>>(200, Constant.Success, page);
        }catch (Exception e){
            return new Request<String>(400, Constant.BadRequest, Constant.Failed);
        }
    }

    @Override
    public DMNCC save(DMNCC dmncc) {
        return nccRepositories.save(dmncc);
    }
}
