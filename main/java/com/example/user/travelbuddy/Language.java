package com.example.user.travelbuddy;

public class Language {
    private String eng_language,chinese_language,malay_language;

    public Language() {
    }

    public Language(String eng_language, String chinese_language, String malay_language) {
        this.eng_language=eng_language;
        this.chinese_language=chinese_language;
        this.malay_language=malay_language;
    }

    public String getEng_language() {
        return eng_language;
    }

    public void setEng_language(String eng_language) {
        this.eng_language = eng_language;
    }

    public String getChinese_language() {
        return chinese_language;
    }

    public void setChinese_language(String chinese_language) {
        this.chinese_language = chinese_language;
    }

    public String getMalay_language() {
        return malay_language;
    }

    public void setMalay_language(String malay_language) {
        this.malay_language = malay_language;
    }
}


