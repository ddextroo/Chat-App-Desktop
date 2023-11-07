package backend;

import com.google.firebase.auth.AuthErrorCode;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import java.util.*;
public class signup {

    private FirebaseAuth firebaseAuth;
    private String email;
    private String password;
    private String uid;
    private DatabaseReference dbRef;
    private HashMap<String, Object> m;
    private pushValue v;
    private Calendar cal = Calendar.getInstance();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    aes aes = new aes();
    String password1;

    public signup(String email, String password) throws FileNotFoundException {
        try {
            this.firebaseAuth = FirebaseAuth.getInstance();
            new firebaseInit().initFirebase();
            this.dbRef = FirebaseDatabase.getInstance().getReference("users");
            this.email = email;
            this.password = password;
            this.uid = uid;
            password1 = aes.encryptString(password, aes.getPassword());
        } catch (Exception ex) {
            Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean signUp() throws FirebaseAuthException {
        try {
            LocalDate currentDate = LocalDate.now();
//            LocalDate newDate = currentDate.plusMonths(1);
//            String n = newDate.format(formatter);
            String currentDateString = currentDate.format(formatter);
            String getnow = new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());

            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(email)
                    .setPassword(password);
            UserRecord userRecord = firebaseAuth.createUser(request);
            uid = userRecord.getUid();
            
            v = new pushValue(userRecord.getUid());
            m = new HashMap<>();
            m.put("email", email);
            m.put("pass", password1);
            m.put("uid", uid);
            v.pushData("users", m);
            JOptionPane.showMessageDialog(null, "Success: Account Created Successfully. Please login again", "Welcome to LibraTech", INFORMATION_MESSAGE);
            return true;

        } catch (FirebaseAuthException e) {
            if (e.getErrorCode().equals(AuthErrorCode.EMAIL_ALREADY_EXISTS)) {
                JOptionPane.showMessageDialog(null, "Error: Email already exists", "Error", ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error: Invalid format", "Error", ERROR_MESSAGE);
            }
            return false;
        }
    }
}
