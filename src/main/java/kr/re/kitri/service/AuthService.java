package kr.re.kitri.service;

import kr.re.kitri.domain.Memeber;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    //private MemeberDAO memeberDAO;

    public Memeber authenticate(String userId, String pw) {


        //Memeber memeber = memeberDAO.selectMemberByIdAndPass(userId, pw);

        return new Memeber("LEE", "Bruce");

    }

}