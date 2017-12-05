package app.group20.gtnm.xmovie.main.detailMovie;

/**
 * Created by Kunka on 11/11/2017.
 */

public class Actor {
    private String txtActorName;
    private int imgActor;

    public Actor(String txtActorName, int imgActor) {
        this.txtActorName = txtActorName;
        this.imgActor = imgActor;
    }

    public String getTxtActorName() {
        return txtActorName;
    }

    public void setTxtActorName(String txtActorName) {
        this.txtActorName = txtActorName;
    }

    public int getImgActor() {
        return imgActor;
    }

    public void setImgActor(int imgActor) {
        this.imgActor = imgActor;
    }
}
