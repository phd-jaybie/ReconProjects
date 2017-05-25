package unsw.phd.jaybie.recontest;

//import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.reconinstruments.ui.list.SimpleListActivity;
import com.reconinstruments.ui.list.StandardListItem;


public class MainActivity extends SimpleListActivity {

    static final String CAMERA_APP= "com.reconinstruments.camera";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_standard_layout);
        setContents(
            new ListItem("Start Camera", new Intent(CAMERA_APP)));//,
            //new ListItem("Start Activity B", IntentB),
            //new ListItem("Start Activity C", IntentC));
    }

    public class ListItem extends StandardListItem {
        Intent intent;
        public ListItem(String text, Intent i) {
            super(text);
            this.intent = i; }
        public void onClick(Context context) {
            context.startActivity(intent);
        }
    }
}
