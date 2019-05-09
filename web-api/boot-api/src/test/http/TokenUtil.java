import com.vpclub.util.IpUtil;
import com.vpclub.auth.TokenPrincipal;
import com.vpclub.auth.TokenUtils;

public class TokenUtil {



    public static void main(String[] args) {
        TokenPrincipal tokenPrincipal = new TokenPrincipal();
        tokenPrincipal.setUserId(1l);
        tokenPrincipal.setUserIp("127.0.0.1");
        System.out.println(TokenUtils.sign(tokenPrincipal, 3600 * 12 * 1000 ));
    }

    
}
