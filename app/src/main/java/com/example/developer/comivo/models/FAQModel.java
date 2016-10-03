package com.example.developer.comivo.models;


import java.util.List;

public class FAQModel {

    private String fAQSectionId;
    private String title;
    private List<FAQBoxModelList> faqBoxModelList;

    public class FAQBoxModelList {
        private String fAQBoxId;
        private String title;
        private List<FAQModelList> faqModelLists;

        public FAQBoxModelList(String fAQBoxId, String title, List<FAQModelList> faqModelLists) {
            this.fAQBoxId = fAQBoxId;
            this.title = title;
            this.faqModelLists = faqModelLists;
        }

        public String getfAQBoxId() {
            return fAQBoxId;
        }

        public void setfAQBoxId(String fAQBoxId) {
            this.fAQBoxId = fAQBoxId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<FAQModelList> getFaqModelLists() {
            return faqModelLists;
        }

        public void setFaqModelLists(List<FAQModelList> faqModelLists) {
            this.faqModelLists = faqModelLists;
        }
    }

    public class FAQModelList {
        private String fAQId;
        private String question;
        private String answer;

        public FAQModelList(String fAQId, String question, String answer) {
            this.fAQId = fAQId;
            this.question = question;
            this.answer = answer;
        }

        public String getfAQId() {
            return fAQId;
        }

        public void setfAQId(String fAQId) {
            this.fAQId = fAQId;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }
    }

    public String getfAQSectionId() {
        return fAQSectionId;
    }

    public void setfAQSectionId(String fAQSectionId) {
        this.fAQSectionId = fAQSectionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FAQBoxModelList> getFaqBoxModelList() {
        return faqBoxModelList;
    }

    public void setFaqBoxModelList(List<FAQBoxModelList> faqBoxModelList) {
        this.faqBoxModelList = faqBoxModelList;
    }

    public FAQModel(String fAQSectionId, String title, List<FAQBoxModelList> faqBoxModelList) {
        this.fAQSectionId = fAQSectionId;
        this.title = title;
        this.faqBoxModelList = faqBoxModelList;
    }
}
