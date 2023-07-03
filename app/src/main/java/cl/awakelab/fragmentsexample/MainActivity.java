package cl.awakelab.fragmentsexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import cl.awakelab.fragmentsexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    BlankFragment frag1 = BlankFragment.newInstance("1","2");
    BlankFragment2 frag2 = BlankFragment2.newInstance("1","2");
    BlankFragment3 frag3 = BlankFragment3.newInstance("1","2");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frag1.isAdded()){
                    getSupportFragmentManager().beginTransaction().remove(frag1).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView,frag1,"BLANK").commit();
                }
            }
        });

        binding.btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView2,frag2,"BLANK").commit();
            }
        });

        binding.btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView3,frag3,"BLANK").commit();
            }
        });
    }
}