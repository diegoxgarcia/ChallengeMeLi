package ar.com.innovationdg.challengemeli.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import ar.com.innovationdg.challengemeli.R;
import ar.com.innovationdg.challengemeli.constants.Constants;
import ar.com.innovationdg.challengemeli.db.entity.ResultEntity;
import ar.com.innovationdg.challengemeli.viewmodel.MeLiViewModel;

public class SearchResultActivity extends AppCompatActivity {

    private MeLiViewModel meLiViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        meLiViewModel = new ViewModelProvider(this).get(MeLiViewModel.class);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Constants.SEARCH_RESULT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            meLiViewModel.getAll().observe(this, new Observer<List<ResultEntity>>() {
                @Override
                public void onChanged(List<ResultEntity> resultEntities) {
                    // Actualizar el adapter del recyclerview
                }
            });
        }
    }
}
