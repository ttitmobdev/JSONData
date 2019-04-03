package com.example.user.jsondata.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

        @SerializedName("owner")
        @Expose
        private  Owner owner;

        @SerializedName("is_accepted")
        @Expose
        private Boolean isAccepted;

        @SerializedName("score")
        @Expose
        private Integer score;

        @SerializedName("last_activity_date")
        @Expose
        private Integer lastActivityDate;

        @SerializedName("creation_date")
        @Expose
        private Integer creationDate;

        @SerializedName("answer_id")
        @Expose
        private Integer answerId;

        @SerializedName("question_id")
        @Expose
        private Integer questionId;

        public Owner getOwner() {
            return owner;
        }

        public void setOwner(Owner owner) {
            this.owner = owner;
        }

        public Boolean getAccepted() {
            return isAccepted;
        }

        public void setAccepted(Boolean accepted) {
            isAccepted = accepted;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        public Integer getLastActivityDate() {
            return lastActivityDate;
        }

        public void setLastActivityDate(Integer lastActivityDate) {
            this.lastActivityDate = lastActivityDate;
        }

        public Integer getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(Integer creationDate) {
            this.creationDate = creationDate;
        }

        public Integer getAnswerId() {
            return answerId;
        }

        public void setAnswerId(Integer answerId) {
            this.answerId = answerId;
        }

        public Integer getQuestionId() {
            return questionId;
        }

        public void setQuestionId(Integer questionId) {
            this.questionId = questionId;
        }

}
