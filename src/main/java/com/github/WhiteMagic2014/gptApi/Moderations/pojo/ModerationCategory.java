package com.github.WhiteMagic2014.gptApi.Moderations.pojo;

/**
 * @Description: ModerationCategory
 * @author: magic chen
 * @date: 2023/2/24 17:01
 **/
public class ModerationCategory {

    private Boolean hate;
    private Float hateScore;

    private Boolean hateOrThreatening;
    private Float hateOrThreateningScore;

    private Boolean selfHarm;
    private Float selfHarmScore;

    private Boolean sexual;
    private Float sexualScore;

    private Boolean sexualOrMinors;
    private Float sexualOrMinorsScore;

    private Boolean violence;
    private Float violenceScore;

    private Boolean violenceOrGraphic;
    private Float violenceOrGraphicScore;

    public Boolean getHate() {
        return hate;
    }

    public void setHate(Boolean hate) {
        this.hate = hate;
    }

    public Float getHateScore() {
        return hateScore;
    }

    public void setHateScore(Float hateScore) {
        this.hateScore = hateScore;
    }

    public Boolean getHateOrThreatening() {
        return hateOrThreatening;
    }

    public void setHateOrThreatening(Boolean hateOrThreatening) {
        this.hateOrThreatening = hateOrThreatening;
    }

    public Float getHateOrThreateningScore() {
        return hateOrThreateningScore;
    }

    public void setHateOrThreateningScore(Float hateOrThreateningScore) {
        this.hateOrThreateningScore = hateOrThreateningScore;
    }

    public Boolean getSelfHarm() {
        return selfHarm;
    }

    public void setSelfHarm(Boolean selfHarm) {
        this.selfHarm = selfHarm;
    }

    public Float getSelfHarmScore() {
        return selfHarmScore;
    }

    public void setSelfHarmScore(Float selfHarmScore) {
        this.selfHarmScore = selfHarmScore;
    }

    public Boolean getSexual() {
        return sexual;
    }

    public void setSexual(Boolean sexual) {
        this.sexual = sexual;
    }

    public Float getSexualScore() {
        return sexualScore;
    }

    public void setSexualScore(Float sexualScore) {
        this.sexualScore = sexualScore;
    }

    public Boolean getSexualOrMinors() {
        return sexualOrMinors;
    }

    public void setSexualOrMinors(Boolean sexualOrMinors) {
        this.sexualOrMinors = sexualOrMinors;
    }

    public Float getSexualOrMinorsScore() {
        return sexualOrMinorsScore;
    }

    public void setSexualOrMinorsScore(Float sexualOrMinorsScore) {
        this.sexualOrMinorsScore = sexualOrMinorsScore;
    }

    public Boolean getViolence() {
        return violence;
    }

    public void setViolence(Boolean violence) {
        this.violence = violence;
    }

    public Float getViolenceScore() {
        return violenceScore;
    }

    public void setViolenceScore(Float violenceScore) {
        this.violenceScore = violenceScore;
    }

    public Boolean getViolenceOrGraphic() {
        return violenceOrGraphic;
    }

    public void setViolenceOrGraphic(Boolean violenceOrGraphic) {
        this.violenceOrGraphic = violenceOrGraphic;
    }

    public Float getViolenceOrGraphicScore() {
        return violenceOrGraphicScore;
    }

    public void setViolenceOrGraphicScore(Float violenceOrGraphicScore) {
        this.violenceOrGraphicScore = violenceOrGraphicScore;
    }

    @Override
    public String toString() {
        return "ModerationCategory{" +
                "hate=" + hate +
                ", hateScore=" + hateScore +
                ", hateOrThreatening=" + hateOrThreatening +
                ", hateOrThreateningScore=" + hateOrThreateningScore +
                ", selfHarm=" + selfHarm +
                ", selfHarmScore=" + selfHarmScore +
                ", sexual=" + sexual +
                ", sexualScore=" + sexualScore +
                ", sexualOrMinors=" + sexualOrMinors +
                ", sexualOrMinorsScore=" + sexualOrMinorsScore +
                ", violence=" + violence +
                ", violenceScore=" + violenceScore +
                ", violenceOrGraphic=" + violenceOrGraphic +
                ", violenceOrGraphicScore=" + violenceOrGraphicScore +
                '}';
    }
}
