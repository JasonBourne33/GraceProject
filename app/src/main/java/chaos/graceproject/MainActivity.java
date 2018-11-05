package chaos.graceproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import chaos.base.BaseActivity;
import chaos.base.MyApplication;
import chaos.bean.Person;
import chaos.bean.PersonParcelable;

public class MainActivity extends BaseActivity {

    private static final String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        Person person = (Person) getIntent().getSerializableExtra("person_data");
        PersonParcelable person = getIntent().getParcelableExtra("person_data");
        Log.e(TAG, "person name=== "+person.getName() );
        Log.e(TAG, "person age=== "+person.getAge() );
    }


    @OnClick({R.id.btn_forceOffLine, R.id.btn_toast})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_forceOffLine:
                Intent intent = new Intent("chaos.graceproject.FORCE_OFFLINE");
                sendBroadcast(intent);
                break;
            case R.id.btn_toast:
                Toast.makeText(MyApplication.getContext(),"test toast=== ",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
