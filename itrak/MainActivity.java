package softwaredesign.itrak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView listView_allInventory;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView_allInventory = (ListView) findViewById(R.id.ListView_allInventory);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.menu_new_inventory:
                startActivity(new Intent(MainActivity.this,InventoryDetailsActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected  void onResume()
    {

        DataBaseHelper db = new DataBaseHelper(this);
        ArrayList<String> names = new ArrayList<String>();

        for (int i=0; i<db.getAllInventory().size(); i++)
            names.add(db.getAllInventory().get(i).getItem_name());

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, names);
        listView_allInventory.setAdapter(adapter);

        super.onResume();
    }
}
