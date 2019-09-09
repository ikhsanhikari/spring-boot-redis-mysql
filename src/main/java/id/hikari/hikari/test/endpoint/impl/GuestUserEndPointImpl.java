package id.hikari.hikari.test.endpoint.impl;
import id.hikari.hikari.test.core.impl.BaseEndPointImpl;
import id.hikari.hikari.test.dao.GuestUserDAO;
import id.hikari.hikari.test.data.dto.request.RequestLogin;
import id.hikari.hikari.test.data.dto.response.JsonWrapper;
import id.hikari.hikari.test.data.dto.response.ResponseLogin;
import id.hikari.hikari.test.data.model.GuestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("guest_users")
public class GuestUserEndPointImpl extends BaseEndPointImpl<GuestUser,Integer> {

    @Autowired
    private GuestUserDAO guestUserDAO;

    @PostMapping("/loginGuest")
    public ResponseEntity login(@RequestBody RequestLogin requestLogin){
        List<GuestUser> guestUsers = guestUserDAO.findByUsername(requestLogin.getUsername());
        Boolean status = false;
        Integer idUser = 0;

        for (GuestUser guestUser: guestUsers) {
            idUser = guestUser.getId();
        }
        if(guestUsers.size()>0){
            status = true;
        }

        return ResponseEntity.ok(new JsonWrapper(0,"Login", HttpStatus.OK,new ResponseLogin(status,idUser)));
    }

    @PostMapping("/save")
    public ResponseEntity saveData(@RequestBody GuestUser guestUser){
        guestUserDAO.save(guestUser);
        return ResponseEntity.ok(new JsonWrapper(0,"Login", HttpStatus.OK,guestUser));
    }

}
