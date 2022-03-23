package com.example.android;

public class word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mSoundResourceId;

    public word(String defaultTranslation,String miwokTranslation,int soundResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mSoundResourceId = soundResourceId;
    }
    public word(String defaultTranslation,String miwokTranslation,int imageResourceId,int soundResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mSoundResourceId = soundResourceId;
    }
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public int getSoundResourceId(){ return mSoundResourceId; }
    public int getmImageResourceId(){
        return mImageResourceId;
    }
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    @Override
    public String toString() {
        return "word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mSoundResourceId=" + mSoundResourceId +
                '}';
    }
}
