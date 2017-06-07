package com.integratedideas.speechandaudio;

/**
 * Created by user on 2017-06-06.
 */

public class Person {
    private int _id;
    private String n_music;
    private String n_man;
    private String n_ge;
    private String v_min;
    private String v_max;

    public int get_id() {
        return _id;
    }

    public String getMusicName() {
        return n_music;
    }
    public String getManName() {
        return n_man;
    }
    public String getGeName() {
        return n_ge;
    }
    public String getMin() {
        return v_min;
    }
    public String getMax() {
        return v_max;
    }


    public void set_id(int _id) {
        this._id = _id;
    }

    public void setMusicName(String name) {
        this.n_music = name;
    }

    public void setManName(String name) {
        this.n_man = name;
    }

    public void setGeName(String name) {
        this.n_ge = name;
    }

    public void setMin(String name) {
        this.v_min = name;
    }

    public void setMax(String name) {
        this.v_max = name;
    }

}
