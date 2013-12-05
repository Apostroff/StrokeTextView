package mobi.apai.StrokeTextView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.stroketv).setOnClickListener(onLick);
    }
    View.OnClickListener onLick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d("CLICK", "CLICK");
            Toast.makeText(MyActivity.this, "CLICK", Toast.LENGTH_SHORT).show();
        }
    };
}
