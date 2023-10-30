package backend;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.firebase.auth.FirebaseAuth;
import java.io.InputStream;

public class firebaseInit {

    public void initFirebase() {
        //FileInputStream refreshToken = null;
        InputStream refreshToken = null;
        refreshToken = this.getClass().getClassLoader().getResourceAsStream("firebase/config.json");
        //refreshToken = new FileInputStream("config.json");
        FirebaseOptions options = null;
        try {
            options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(refreshToken))
                    .setDatabaseUrl("https://chat-app-8b3ec-default-rtdb.asia-southeast1.firebasedatabase.app")
                    .build();
        } catch (IOException ex) {
            Logger.getLogger(firebaseInit.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }

    }
}
