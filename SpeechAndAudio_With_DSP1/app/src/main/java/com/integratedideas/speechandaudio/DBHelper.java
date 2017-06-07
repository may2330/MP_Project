package com.integratedideas.speechandaudio;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-06-06.
 */

public class DBHelper extends SQLiteOpenHelper {

    private Context context;
    private String r_left,r_right;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuffer sb = new StringBuffer();
        sb.append(" CREATE TABLE TEST_TABLE ( ");
        sb.append(" _ID INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(" N_MUSIC TEXT, ");
        sb.append(" N_MAN TEXT, ");
        sb.append(" N_GE TEXT, ");
        sb.append(" V_MIN INTEGER, ");
        sb.append(" V_MAX INTEGER ) ");

        db.execSQL(sb.toString());

        //Toast.makeText(context, "Table 생성 완료", Toast.LENGTH_SHORT).show();

        StringBuffer cb = new StringBuffer();
        cb.append(" CREATE TABLE TEST_TABLE_SCALE ( ");
        cb.append(" _ID INTEGER PRIMARY KEY AUTOINCREMENT, ");
        cb.append(" MIN INTEGER, ");
        cb.append(" MAX INTEGER ) ");

        db.execSQL(cb.toString());
        //Toast.makeText(context, "Table 생성 완료", Toast.LENGTH_SHORT).show();

        r_left = "0";
        r_right = "0";

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(context, "버전이 올라갔습니다.", Toast.LENGTH_SHORT).show();
    }

    public void testDB() {
        SQLiteDatabase db = getReadableDatabase();
    }

    public void addPerson(Person person) {
        SQLiteDatabase db = getWritableDatabase();

        StringBuffer sb = new StringBuffer();
        sb.append(" INSERT INTO TEST_TABLE ( ");
        sb.append(" N_MUSIC, N_MAN, N_GE, V_MIN, V_MAX ) ");
        sb.append(" VALUES ( ?, ?, ?, ?, ? ) ");

        db.execSQL(sb.toString(), new Object[]{person.getMusicName(), person.getManName(), person.getGeName(), Integer.parseInt(person.getMin()), Integer.parseInt(person.getMax())});
        //Toast.makeText(context, "DB Insert 완료", Toast.LENGTH_SHORT).show();
    }

    public void addScale(String min, String max) {
        SQLiteDatabase db = getWritableDatabase();

        StringBuffer sb = new StringBuffer();
        sb.append(" INSERT INTO TEST_TABLE_SCALE ( ");
        sb.append(" MIN, MAX ) ");
        sb.append(" VALUES ( ?, ? ) ");

        db.execSQL(sb.toString(), new Object[]{Integer.parseInt(min), Integer.parseInt(max)});
        //Toast.makeText(context, "Scale Insert 완료", Toast.LENGTH_SHORT).show();
    }

    public void updateScale(int min, int max) {
        SQLiteDatabase db = getWritableDatabase();

        StringBuffer sb = new StringBuffer();
        sb.append(" UPDATE TEST_TABLE_SCALE SET MIN= "+min+", MAX="+max);

        db.execSQL(sb.toString());
        //Toast.makeText(context, "In DB, Scale Update 완료 : Min"+min+", Max "+max, Toast.LENGTH_SHORT).show();
    }

    public void getScale(){
        StringBuffer sb = new StringBuffer();
        sb.append(" SELECT * FROM TEST_TABLE_SCALE ");

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sb.toString(), null);

        while(cursor.moveToNext()){
            r_left = cursor.getString(1);
            r_right = cursor.getString(2);
        }
    }

    public List getAllMusicData(String str) {
        StringBuffer sb = new StringBuffer();

        sb.append(" SELECT _ID, N_MUSIC, N_MAN, N_GE, V_MIN, V_MAX FROM TEST_TABLE WHERE (N_MUSIC LIKE '%"+str+
                "%') OR (N_MAN LIKE '%"+str+"%')");

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sb.toString(), null);
        List people = new ArrayList();
        Person person = null;

        while (cursor.moveToNext()) {
            person = new Person();
            person.set_id(cursor.getInt(0));
            person.setMusicName(cursor.getString(1));
            person.setManName(cursor.getString(2));
            person.setGeName(cursor.getString(3));
            person.setMin(Integer.toString(cursor.getInt(4)));
            person.setMax(Integer.toString(cursor.getInt(5)));
            people.add(person);
          }
        return people;
    }

    public List getBaladMusicData() {
        StringBuffer sb = new StringBuffer();

        getScale();
        Toast.makeText(context,"min : "+r_left+", max : "+r_right,Toast.LENGTH_SHORT).show();
        sb.append(" SELECT _ID, N_MUSIC, N_MAN, N_GE, V_MIN, V_MAX FROM TEST_TABLE WHERE N_GE='발라드' AND (V_MIN > "+r_left
                +") AND (V_MAX <" + r_right+")");

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sb.toString(), null);
        List people = new ArrayList();
        Person person = null;

        while (cursor.moveToNext()) {
            person = new Person();
            person.set_id(cursor.getInt(0));
            person.setMusicName(cursor.getString(1));
            person.setManName(cursor.getString(2));
            person.setGeName(cursor.getString(3));
            person.setMin(Integer.toString(cursor.getInt(4)));
            person.setMax(Integer.toString(cursor.getInt(5)));
            people.add(person);
        }
        return people;
    }

    public List getDanceMusicData() {
        StringBuffer sb = new StringBuffer();

        getScale();
        Toast.makeText(context,"min : "+r_left+", max : "+r_right,Toast.LENGTH_SHORT).show();
        sb.append(" SELECT _ID, N_MUSIC, N_MAN, N_GE, V_MIN, V_MAX FROM TEST_TABLE WHERE N_GE='댄스' AND (V_MIN > "+r_left
                +") AND (V_MAX <" + r_right+")");

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sb.toString(), null);
        List people = new ArrayList();
        Person person = null;

        while (cursor.moveToNext()) {
            person = new Person();
            person.set_id(cursor.getInt(0));
            person.setMusicName(cursor.getString(1));
            person.setManName(cursor.getString(2));
            person.setGeName(cursor.getString(3));
            person.setMin(Integer.toString(cursor.getInt(4)));
            person.setMax(Integer.toString(cursor.getInt(5)));
            people.add(person);
        }
        return people;
    }

    public List getPopMusicData() {
        StringBuffer sb = new StringBuffer();

        getScale();
        Toast.makeText(context,"min : "+r_left+", max : "+r_right,Toast.LENGTH_SHORT).show();
        sb.append(" SELECT _ID, N_MUSIC, N_MAN, N_GE, V_MIN, V_MAX FROM TEST_TABLE WHERE N_GE='팝송' AND (V_MIN > "+r_left
                +") AND (V_MAX <" + r_right+")");


        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sb.toString(), null);
        List people = new ArrayList();
        Person person = null;

        while (cursor.moveToNext()) {
            person = new Person();
            person.set_id(cursor.getInt(0));
            person.setMusicName(cursor.getString(1));
            person.setManName(cursor.getString(2));
            person.setGeName(cursor.getString(3));
            person.setMin(Integer.toString(cursor.getInt(4)));
            person.setMax(Integer.toString(cursor.getInt(5)));
            people.add(person);
        }
        return people;
    }

    public List getTrotMusicData() {
        StringBuffer sb = new StringBuffer();

        getScale();
        Toast.makeText(context,"min : "+r_left+", max : "+r_right,Toast.LENGTH_SHORT).show();
        sb.append(" SELECT _ID, N_MUSIC, N_MAN, N_GE, V_MIN, V_MAX FROM TEST_TABLE WHERE N_GE='락' AND (V_MIN > "+r_left
                +") AND (V_MAX <" + r_right+")");


        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sb.toString(), null);
        List people = new ArrayList();
        Person person = null;

        while (cursor.moveToNext()) {
            person = new Person();
            person.set_id(cursor.getInt(0));
            person.setMusicName(cursor.getString(1));
            person.setManName(cursor.getString(2));
            person.setGeName(cursor.getString(3));
            person.setMin(Integer.toString(cursor.getInt(4)));
            person.setMax(Integer.toString(cursor.getInt(5)));
            people.add(person);
        }
        return people;
    }

    public boolean checkFirst() {
        SQLiteDatabase db = getReadableDatabase();
        StringBuffer sb = new StringBuffer();
        sb.append(" SELECT _ID, N_MUSIC, N_MAN, N_GE, V_MIN, V_MAX FROM TEST_TABLE ");
        Cursor cursor = db.rawQuery(sb.toString(), null);

        if (cursor.moveToNext()) {
            if (cursor.getInt((0)) == 1)
                return false;
            return true;
        }
        return true;
    }
}
