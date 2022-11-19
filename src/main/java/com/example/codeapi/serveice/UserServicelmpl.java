package com.example.codeapi.serveice;

import com.example.codeapi.Common.Constant;
import com.example.codeapi.dto.PageUser;
import com.example.codeapi.dto.Request;
import com.example.codeapi.models.User;
import com.example.codeapi.repositories.UserRepository;
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
public class UserServicelmpl implements UserService{
    @Autowired
    private UserRepository userRepositories;

    @Override
    public Request<?> findByPagingCriteria(PageUser pageUser) {
        Pageable pageable = PageRequest.of(pageUser.getPage().getPageNo(),pageUser.getPage().getPageSize());
        try{
            Page page = userRepositories.findAll(new Specification<User>() {
                @Override
                public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    List<Predicate> predicates = new ArrayList<>();
                    if(pageUser.getUser().getUsername() != null )
                    {
                        predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("username"), "%"+pageUser.getUser().getUsername() +"%")));
                    }

                    if(pageUser.getUser().getPassword() != null )
                    {
                        predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("password"), "%"+pageUser.getUser().getPassword() +"%")));
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
    public User save(User user) {
        return userRepositories.save(user);
    }

    @Override
    public Request<?> delete(User userDelete) {
        Optional<User> userOptional = userRepositories.findById(userDelete.getId());
        try{
            if(userOptional.isPresent())
            {
                User user = userOptional.get();
                userRepositories.deleteById(userDelete.getId());
                return new Request<User>(200, Constant.Success, user);
            }
            return new Request<String>(400, Constant.BadRequest, Constant.DataID);
        }catch (Exception e){
            return new Request<String>(400, Constant.BadRequest, e.getMessage());
        }
    }

    @Override
    public Request<?> update(User userNew) {
        Optional<User> userOptional = userRepositories.findById(userNew.getId());
            try{
                if(userOptional.isPresent())
                {
                    User userOld = userOptional.get();
                    if(userNew.getUsername()!=null){
                        userOld.setUsername(userNew.getUsername());
                    }
                    if(userNew.getPassword()!=null){
                        userOld.setPassword(userNew.getPassword());
                    }
                    this.userRepositories.save(userOld);
                    return new Request<User>(200, Constant.Success, userOld);
                }
                return new Request<String>(404, Constant.Failed, Constant.DataID);
            }catch (Exception e){
                return new Request<String>(400, Constant.BadRequest, e.getMessage());
            }
    }

    @Override
    public List<User> findAll() {
        return userRepositories.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        });
    }
}
