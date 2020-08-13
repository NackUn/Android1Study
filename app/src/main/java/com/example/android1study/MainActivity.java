package com.example.android1study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.android1study.NetworkModule.getNetworkModule;

public class MainActivity extends AppCompatActivity {

    private CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCompositeDisposable = new CompositeDisposable();

        mCompositeDisposable.add(
                getNetworkModule().getRetrofit().create(SearchMovieService.class).requestSearchMovie("해리포터")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                success -> {
                                    if (success != null) {
                                        List<MovieEntity> movieEntityList = success.getItems();
                                        for (MovieEntity movieEntity : movieEntityList) {
                                            Log.e("aa12", movieEntity.getTitle());
                                        }
                                    } else {
                                        Log.e("aa12", "success is null");
                                    }
                                }, fail -> Log.e("aa12", fail.toString())
                        )
        );
    }

    @Override
    protected void onStop() {
        mCompositeDisposable.clear();
        super.onStop();
    }
}
