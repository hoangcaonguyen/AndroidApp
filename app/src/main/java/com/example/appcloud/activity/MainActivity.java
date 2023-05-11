package com.example.appcloud.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appcloud.R;
import com.example.appcloud.model.UserAccount;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private UserAccount userAccount;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Tìm TextView với id là "register"
        TextView registerTextView1 = findViewById(R.id.register);
        TextView registerTextView2 = findViewById(R.id.forgot_password);
        loginButton = findViewById(R.id.btn_login);
        usernameEditText = findViewById(R.id.et_username);
        passwordEditText = findViewById(R.id.et_password);
        userAccount = new UserAccount("admin", "password");
        // Đăng ký bộ xử lý sự kiện khi người dùng nhấn vào TextView "register"
        registerTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để chuyển sang RegisterActivity
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        registerTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để chuyển sang RegisterActivity
                Intent intent = new Intent(MainActivity.this, Forgot.class);
                startActivity(intent);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Lấy dữ liệu từ EditText
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // So sánh dữ liệu từ EditText với đối tượng UserAccount
            if (username.equals(userAccount.getUserName()) && password.equals(userAccount.getPassWord())) {
                // Đăng nhập thành công
                loginButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                });
            } else {
                // Đăng nhập thất bại

            };

        }});
    }

}