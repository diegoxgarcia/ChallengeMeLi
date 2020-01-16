package ar.com.innovationdg.challengemeli.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import ar.com.innovationdg.challengemeli.R;
import ar.com.innovationdg.challengemeli.constants.Constants;
import ar.com.innovationdg.challengemeli.retrofit.Results;
import ar.com.innovationdg.challengemeli.viewmodel.MeLiViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MeLiViewModel meLiViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Button searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(this);
    }

    private void searchItem(){
        EditText searchText = findViewById(R.id.searchText);
        String item = searchText.getText().toString();
        meLiViewModel = new ViewModelProvider(this).get(MeLiViewModel.class);
        meLiViewModel.getAllSearchData(item).observe(this, new Observer<List<Results>>() {
            @Override
            public void onChanged(List<Results> results) {
                meLiViewModel.insertAllResults(results);
                goToSearchResultActivity();
            }
        });
    }


    private void goToSearchResultActivity(){
        Intent intent = new Intent(MainActivity.this, SearchResultActivity.class);
        startActivityForResult(intent, Constants.SEARCH_RESULT_ACTIVITY_REQUEST_CODE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.searchButton:
                searchItem();
                break;
        }
    }

}
