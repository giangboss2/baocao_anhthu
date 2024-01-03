package project.anhthu.travelinvietnam_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import project.anhthu.travelinvietnam_app.R;

public class ActivityRegister extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText username, password, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        username = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPersonName3);
        confirmPassword = findViewById(R.id.editTextTextPersonName2);
        ConstraintLayout signUpButton = findViewById(R.id.textview5);
        TextView loginTextView = findViewById(R.id.textView3);

        loginTextView.setOnClickListener(view -> {
            // Chuyển người dùng đến màn hình đăng nhập (LoginActivity)
            Intent loginIntent = new Intent(ActivityRegister.this, ActivityLogin.class);
            startActivity(loginIntent);
            finish(); // Đóng màn hình đăng ký
        });

        signUpButton.setOnClickListener(view -> performRegistration());
    }

    private void performRegistration() {
        String email = username.getText().toString().trim();
        String password = this.password.getText().toString().trim();
        String confirmPassword = this.confirmPassword.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty() || !password.equals(confirmPassword)) {
            // Hiển thị thông báo lỗi
            Toast.makeText(ActivityRegister.this, "Vui lòng kiểm tra thông tin đăng ký", Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Đăng ký thành công
                        Toast.makeText(ActivityRegister.this, "Đăng ký thành công", Toast.LENGTH_LONG).show();

                        // Lưu thông tin tài khoản vào Firebase Realtime Database
                        FirebaseUser user = mAuth.getCurrentUser();
                        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");

                        // Tạo nút (node) mới với UID của người dùng
                        DatabaseReference userNode = databaseReference.child(user.getUid());

                        // Lưu thông tin tài khoản vào nút userNode
                        userNode.child("email").setValue(email);
                        userNode.child("password").setValue(password);
                        Intent intent = new Intent(ActivityRegister.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Đăng ký thất bại
                        Toast.makeText(ActivityRegister.this, "Đăng ký thất bại: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

    }
}
