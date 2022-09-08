package com.vmware.CapstoneSearch;

public class Hit {
    private String _index;
    private String _type;
    private String _id;
    private float _score;
    private Source source;

    public Hit(String _index, String _type, String _id, float _score, Source source) {
        this._index = _index;
        this._type = _type;
        this._id = _id;
        this._score = _score;
        this.source = source;
    }

    public Hit() {
    }

    public String get_index() {
        return _index;
    }

    public void set_index(String _index) {
        this._index = _index;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public float get_score() {
        return _score;
    }

    public void set_score(float _score) {
        this._score = _score;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Hit{" +
                "_index='" + _index + '\'' +
                ", _type='" + _type + '\'' +
                ", _id='" + _id + '\'' +
                ", _score=" + _score +
                ", source=" + source +
                '}';
    }
}
