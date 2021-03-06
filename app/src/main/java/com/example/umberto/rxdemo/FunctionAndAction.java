package com.example.umberto.rxdemo;

import android.util.Log;

import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class FunctionAndAction {


    public static Func1<List<String>, Observable<String>> getFunctionConvertListToStringFunction() {

        return new Func1<List<String>, Observable<String>>() {
            @Override
            public Observable<String> call(List<String> urls) {

//          Observable.from(urls); that takes a collection of items and emits each them one at a time
                return Observable.from(urls);
            }
        };
    }

    public static Func1<String, String> getFunctionMapUrl() {

        return new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s + " + map \n";
            }
        };
    }

    public static Func1<String, Observable<String>> getFunctionForGetPayload() {

        return new Func1<String, Observable<String>>() {
            @Override
            public Observable<String> call(String s) {
                return MockServerCall.getPayloadFromUrl(s);
            }
        };
    }

    public static Func1<? super String, Boolean> getFunctionFilterNullValue() {
        return new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return !s.equals("null");
            }
        };
    }

    public static Action1<? super String> getActionSaveInDb() {
        return new Action1<String>() {
            @Override
            public void call(String s) {
                Log.w("DB","Store in db");
            }
        };
    }

    public static Func1<String, String> getFunctionWithPotentialException(){
        return new Func1<String, String>() {
            @Override
            public String call(String s){
                if(s.equals("testerror"))return null;
                return s;
            }
        };
    }
}
