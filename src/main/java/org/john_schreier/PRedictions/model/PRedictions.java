package org.john_schreier.PRedictions.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class PRedictions implements Serializable {
    //    This class binds a user's personalized race predictions to an object to be saved in the db
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long predictionId;
    @Column
    private String halfMarathonPrediction;
    @Column
    private String marathonPrediction;
    @OneToOne
    private User user;

    public PRedictions() {
    }

    public PRedictions(long predictionId, String halfMarathonPrediction, String marathonPrediction) {
        this.predictionId = predictionId;
        this.halfMarathonPrediction = halfMarathonPrediction;
        this.marathonPrediction = marathonPrediction;
    }

    public long getPredictionId() {
        return predictionId;
    }

    public void setPredictionId(long predictionId) {
        this.predictionId = predictionId;
    }

    public String getHalfMarathonPrediction() {
//        if (halfMarathonPrediction==null){
//            return "No Half Marathon Prediction Yet!";
//        }
        return halfMarathonPrediction;
    }

    public void setHalfMarathonPrediction(String halfMarathonPrediction) {
        this.halfMarathonPrediction = halfMarathonPrediction;
    }

    public String getMarathonPrediction() {
//        if (marathonPrediction==null){
//            return "Marathon Prediction Yet!";
//        }
        return marathonPrediction;
    }

    public void setMarathonPrediction(String marathonPrediction) {
        this.marathonPrediction = marathonPrediction;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PRedictions{" +
                "predictionId=" + predictionId +
                ", halfMarathonPrediction='" + halfMarathonPrediction + '\'' +
                ", marathonPrediction='" + marathonPrediction + '\'' +
                '}';
    }
}
//String s = "46:23:12";
//String[] values = s.split(":");
//// get the hours, minutes and seconds value and add it to the duration
//Duration duration = Duration.ofHours(Integer.parseInt(values[0]));
//duration = duration.plusMinutes(Integer.parseInt(values[1]));
//duration = duration.plusSeconds(Integer.parseInt(values[2]));