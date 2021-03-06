package model;

public class Player {

    private String name;
    private String nickName;
    private int category;
    private double score;

    public Player(String name, String nickName, int category, double score) {
        this.name = name;
        this.nickName = nickName;
        this.category = category;
        this.score = score;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player{" +
                       "name='" + name + '\'' +
                       ", nickName='" + nickName + '\'' +
                       ", category=" + category +
                       ", score=" + score +
                       '}';
    }
}
