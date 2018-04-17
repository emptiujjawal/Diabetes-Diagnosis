 package empti.diabetesdiagnosis;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private Button register;
    private EditText user,pass;
    private TextView login;

    private FirebaseAuth mAuth;
    private ProgressDialog mprogress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        register= (Button)findViewById(R.id.logbtn);
        user = (EditText)findViewById(R.id.textuserreg);
        pass = (EditText)findViewById(R.id.textpassreg);
        login = (TextView)findViewById(R.id.textacc);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = user.getText().toString().trim();
                String password = pass.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(LoginActivity.this,"Fill Your Username",Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this,"Fill Your Password",Toast.LENGTH_LONG).show();
                    return;
                }

                mprogress = new ProgressDialog(LoginActivity.this);
                mprogress.setTitle("Check For Your Anthentication");
                mprogress.setMessage("Please Wait Login !!");
                mprogress.show();

                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            mprogress.dismiss();

                            startActivity(new Intent(LoginActivity.this,Mainnext.class));
                            finish();
                        }
                        else{
                            Toast.makeText(LoginActivity.this,"Error You are not Anthenticate User !!",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
