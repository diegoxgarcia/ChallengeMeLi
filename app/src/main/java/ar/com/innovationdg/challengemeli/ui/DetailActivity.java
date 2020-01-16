package ar.com.innovationdg.challengemeli.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.xml.transform.Result;

import ar.com.innovationdg.challengemeli.R;
import ar.com.innovationdg.challengemeli.db.entity.ResultEntity;
import ar.com.innovationdg.challengemeli.viewmodel.MeLiViewModel;

public class DetailActivity extends AppCompatActivity {

    private MeLiViewModel meLiViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setTitle("Detalle de Item");

        meLiViewModel = new ViewModelProvider(this).get(MeLiViewModel.class);

        meLiViewModel.getDataById(getIntent().getIntExtra("idRoom", 0)).observe(this, new Observer<List<ResultEntity>>() {
            @Override
            public void onChanged(List<ResultEntity> resultEntities) {
                ImageView ivImage = findViewById(R.id.ivThumb);
                TextView tvTitle = findViewById(R.id.tvTitle);
                TextView tvId = findViewById(R.id.tvId);
                TextView tvCity = findViewById(R.id.tvCity);

                ResultEntity re = resultEntities.get(0);
                tvTitle.setText(re.getTitle());
                tvId.setText(re.getId());
                tvCity.setText(re.getCity_name());
                Picasso.get().load(re.getThumbnail().replace("http","https")).resize(200, 200).centerCrop().into(ivImage);
            }
        });



    }
}
