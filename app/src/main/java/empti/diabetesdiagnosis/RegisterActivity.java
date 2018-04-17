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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.HashMap;

import empti.diabetesdiagnosis.LoginActivity;

public class RegisterActivity extends AppCompatActivity {

    private Button register;
    private EditText user,pass,display;
    private TextView login;
    private RadioButton doctor, patient;
    private RadioGroup radioGroup;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private DatabaseReference mUserDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        register= (Button)findViewById(R.id.regbtn);
        user = (EditText)findViewById(R.id.textuser);
        pass = (EditText)findViewById(R.id.textpass);
        login = (TextView)findViewById(R.id.textregister);
        doctor = (RadioButton)findViewById(R.id.doctorbtn);
        patient = (RadioButton)findViewById(R.id.patientbtn);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        display = (EditText)findViewById(R.id.textdisplay);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = user.getText().toString().trim();
                String password = pass.getText().toString().trim();
                final String name = display.getText().toString().trim();

                if (TextUtils.isEmpty(email)){

                    Toast.makeText(RegisterActivity.this,"Fill Your Username",Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterActivity.this,"Fill Your Password",Toast.LENGTH_LONG).show();
                    return;
                }
                if (radioGroup.getCheckedRadioButtonId() == -1){
                    Toast.makeText(RegisterActivity.this,"Check anyone of the option",Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(name)){
                    Toast.makeText(RegisterActivity.this,"Fill Your Display Name",Toast.LENGTH_LONG).show();
                    return;
                }

                if (doctor.isChecked()){
                    String doc = "Doctors";
                }else{
                    String doc = "Patients";
                }

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            ProgressDialog mprogres = new ProgressDialog(RegisterActivity.this);
                            mprogres.setTitle("Your are  Authenticate");
                            mprogres.setMessage("Your Database Is Managing!!");
                            mprogres.show();

                            FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                            String uid = currentUser.getUid();

                            if (doctor.isChecked()){
                                mDatabase = FirebaseDatabase.getInstance().getReference().child("Doctors").child(uid);
                                mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Doctors");
                            }else{
                                mDatabase = FirebaseDatabase.getInstance().getReference().child("Patients").child(uid);
                                mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Patients");
                            }
                            HashMap<String, String> userMap = new HashMap<String, String>();
                            userMap.put("name", name);

                            mDatabase.setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        String mCurrentuserid = mAuth.getCurrentUser().getUid();
                                        String devicetoken = FirebaseInstanceId.getInstance().getToken();

                                        mUserDatabase.child(mCurrentuserid).child("device_token").setValue(devicetoken).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {

                                                finish();
                                                //start profile activity
                                                startActivity(new Intent(RegisterActivity.this, Mainnext.class));


                                                //user is successfully registered and login
                                                //we will start the profile actitvity
                                                Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();

                                            }
                                        });
                                    }

                                }
                            });






                        }
                        else {
                            Toast.makeText(RegisterActivity.this,"Registeration Is Failed!! Try Again..",Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });
    }
}
