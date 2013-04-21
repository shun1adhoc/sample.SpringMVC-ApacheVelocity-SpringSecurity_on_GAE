


import org.springframework.security.crypto.password.StandardPasswordEncoder;



public class PasswordEncode {
        public static void main(String[] args) throws Exception {
            StandardPasswordEncoder encoder = new StandardPasswordEncoder();
            System.out.println(encoder.encode("admin"));
            System.out.println(encoder.encode("bob"));
        }
}
