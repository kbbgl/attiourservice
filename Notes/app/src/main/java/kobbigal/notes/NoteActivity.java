package kobbigal.notes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class NoteActivity extends AppCompatActivity {

    EditText noteInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
        setContentView(R.layout.activity_note);

        noteInputEditText = (EditText) findViewById(R.id.noteInput);

        loadSavedPreferences();
    }

    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        noteInputEditText.setText(sharedPreferences.getString("str", ""));
    }

    private void savePreferences(String key, String value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void saveData(){
        savePreferences("str", noteInputEditText.getText().toString());
        Log.i("str",noteInputEditText.getText().toString());
    }

    @Override
    public void onBackPressed() {
        saveData();
        Intent returnIntent = getIntent();
        returnIntent.putExtra("str", "");
        super.onBackPressed();
    }
}
