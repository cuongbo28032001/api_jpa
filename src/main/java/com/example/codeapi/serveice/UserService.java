package com.example.codeapi.serveice;

import com.example.codeapi.dto.PageUser;
import com.example.codeapi.dto.Request;
import com.example.codeapi.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepositories;
//    public List<User> getAllUser(Integer pageNo, Integer pageSize)
//    {
//        PageRequest pageable = PageRequest.of(pageNo, pageSize);
//        Page<User> userPageResult = userRepositories.findAll(pageable);
//        if(userPageResult.hasContent())
//        {
//            return userPageResult.getContent();
//        }
//        else{
//            return new ArrayList<User>();
//        }
//    }
//
//}

public interface UserService {
    List<User> findAll();
    Request<?> findByPagingCriteria(PageUser pageUser);
    User save(User user);
    Request<?> delete(User user);
    Request<?> update(User user);
}
