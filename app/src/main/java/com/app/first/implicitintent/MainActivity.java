package com.app.first.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Launch(View view){
        Intent intent=null ,chooser=null;

        if (view.getId()==R.id.map){
            intent=new Intent(android.content.Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:25.5028944,83.4565915"));
            chooser=Intent.createChooser(intent,"map");
            startActivity(chooser);
        }
        if (view.getId()==R.id.marcket){
            intent=new Intent(android.content.Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://dev?id=5408830062919995155&hl=en"));
            chooser=intent.createChooser(intent,"marcket");
            startActivity(chooser);
        }
        if(view.getId()==R.id.email){
            intent=new Intent(Intent.ACTION_SEND);     //this is the pre defind actiin inside the Intent class
            intent.setData(Uri.parse("mailto:"));      //mailto is protocoll
            String[]to={"akhiesh.reso@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to); //main body of sending email
            intent.putExtra(Intent.EXTRA_SUBJECT, "hi");
            intent.putExtra(Intent.EXTRA_TEXT,"Hi buddy ");
            intent.setType("massage/rfc822");      //without putting this type there is no activity found these
            chooser=intent.createChooser(intent,"email");
            startActivity(chooser);

        }



    }
}
