package softwaredesign.itrak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InventoryDetailsActivity extends AppCompatActivity {

    private EditText editText_name;
    private EditText editText_serial;
    private EditText editText_location;
    private Button button_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_details);

        editText_name =(EditText) findViewById(R.id.editText_name);
        editText_serial =(EditText) findViewById(R.id.editText_serial);
        editText_location =(EditText) findViewById(R.id.editText_location);
        button_save = (Button) findViewById(R.id.button_save);

        button_save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                saveInventory();
            }
        });
    }

    private void saveInventory() {

        DataBaseHelper db = new DataBaseHelper(this);
        Inventory newInventory = new Inventory();
        newInventory.setItem_name(editText_name.getText().toString());
        newInventory.setItem_serial(editText_serial.getText().toString());
        newInventory.setItem_location(editText_location.getText().toString());

       db.insertInventory(newInventory);
       finish();
    }
}
