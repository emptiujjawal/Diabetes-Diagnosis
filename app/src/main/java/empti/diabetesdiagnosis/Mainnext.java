package empti.diabetesdiagnosis;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Mainnext extends AppCompatActivity {

    private Button submit;
    private DatabaseReference mDatabase;

    private Switch s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26,s27,s28,s29,s30,s31,s32,s33,s34,s35,s36,s37,s38,s39,s40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainnext);



        submit = (Button)findViewById(R.id.submitbtn);

        s1 = (Switch)findViewById(R.id.switch1);
        s2 = (Switch)findViewById(R.id.switch2);
        s3 = (Switch)findViewById(R.id.switch3);
        s4 = (Switch)findViewById(R.id.switch4);
        s5 = (Switch)findViewById(R.id.switch5);
        s6 = (Switch)findViewById(R.id.switch6);
        s7 = (Switch)findViewById(R.id.switch7);
        s8 = (Switch)findViewById(R.id.switch8);
        s9 = (Switch)findViewById(R.id.switch9);
        s10 = (Switch)findViewById(R.id.switch10);
        s11 = (Switch)findViewById(R.id.switch11);
        s12 = (Switch)findViewById(R.id.switch12);
        s13 = (Switch)findViewById(R.id.switch13);
        s14 = (Switch)findViewById(R.id.switch14);
        s15 = (Switch)findViewById(R.id.switch15);
        s16 = (Switch)findViewById(R.id.switch16);
        s17 = (Switch)findViewById(R.id.switch17);
        s18 = (Switch)findViewById(R.id.switch18);
        s19 = (Switch)findViewById(R.id.switch19);
        s20 = (Switch)findViewById(R.id.switch20);
        s21 = (Switch)findViewById(R.id.switch21);
        s22 = (Switch)findViewById(R.id.switch22);
        s23 = (Switch)findViewById(R.id.switch23);
        s24 = (Switch)findViewById(R.id.switch24);
        s25 = (Switch)findViewById(R.id.switch25);
        s26 = (Switch)findViewById(R.id.switch26);
        s27 = (Switch)findViewById(R.id.switch27);
        s28 = (Switch)findViewById(R.id.switch28);
        s29 = (Switch)findViewById(R.id.switch29);
        s30 = (Switch)findViewById(R.id.switch30);
        s31 = (Switch)findViewById(R.id.switch31);
        s32 = (Switch)findViewById(R.id.switch32);
        s33 = (Switch)findViewById(R.id.switch33);
        s34 = (Switch)findViewById(R.id.switch34);
        s35 = (Switch)findViewById(R.id.switch35);
        s36 = (Switch)findViewById(R.id.switch36);
        s37 = (Switch)findViewById(R.id.switch37);
        s38 = (Switch)findViewById(R.id.switch38);
        s39 = (Switch)findViewById(R.id.switch39);
        s40 = (Switch)findViewById(R.id.switch40);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double one = 1, two = 2, three = 3, four = 4, five = 5, onehalf = 1.5, twohalf = 2.5, total = 0;

                if (s1.isChecked()){
                    total = total + five;
                }
                if (s2.isChecked()){
                    total += five;
                }
                if (s3.isChecked()){
                    total+= five;
                }
                if (s4.isChecked()){
                    total+=five;
                }
                if (s5.isChecked()){
                    total+=five;
                }
                if (s6.isChecked()){
                    total+=five;
                }
                if (s7.isChecked()){
                    total+=five;
                }
                if (s8.isChecked()){
                    total+=five;
                }
                if (s9.isChecked()){
                    total+=five;
                }
                if (s10.isChecked()){
                    total+=one;
                }
                if (s11.isChecked()){
                    total+=two;
                }
                if (s12.isChecked()){
                    total+=one;
                }
                if (s13.isChecked()){
                    total+=one;
                }
                if (s14.isChecked()){
                    total+=one;
                }
                if (s15.isChecked()){
                    total+=one;
                }
                if (s16.isChecked()){
                    total+=one;
                }
                if (s17.isChecked()){
                    total+=one;
                }
                if (s18.isChecked()){
                    total+=three;
                }
                if (s19.isChecked()){
                    total+=three;
                }
                if (s20.isChecked()){
                    total+=two;
                }
                if (s21.isChecked()){
                    total = total + onehalf;
                }
                if (s22.isChecked()){
                    total += one;
                }
                if (s23.isChecked()){
                    total+= twohalf ;
                }
                if (s24.isChecked()){
                    total+=one;
                }
                if (s25.isChecked()){
                    total+=one;
                }
                if (s26.isChecked()){
                    total+=one;
                }
                if (s27.isChecked()){
                    total+=two;
                }
                if (s28.isChecked()){
                    total+=two;
                }
                if (s29.isChecked()){
                    total+=one;
                }
                if (s30.isChecked()){
                    total+=one;
                }
                if (s31.isChecked()){
                    total+=one;
                }
                if (s32.isChecked()){
                    total+=one;
                }
                if (s33.isChecked()){
                    total+=twohalf;
                }
                if (s34.isChecked()){
                    total+=twohalf;
                }
                if (s35.isChecked()){
                    total+=one;
                }
                if (s36.isChecked()){
                    total+=two;
                }
                if (s37.isChecked()){
                    total+=twohalf;
                }
                if (s38.isChecked()){
                    total+=two;
                }
                if (s39.isChecked()){
                    total+=one;
                }
                if (s40.isChecked()){
                    total+=four;
                }

                FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                String uid = currentUser.getUid();
                mDatabase = FirebaseDatabase.getInstance().getReference().child("Results").child(uid);

                HashMap<String, Double> userMap = new HashMap<>();
                userMap.put("result", total);

                mDatabase.setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(Mainnext.this,InteractActivity.class));
                        }

                    }
                });

            }
        });



    }
}
