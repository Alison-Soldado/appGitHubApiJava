package br.com.desafioandroidconcrete.data.model.listRepository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by alison on 22/09/17.
 */

public class Permissions implements Serializable {

    @SerializedName("admin")
    @Expose
    private Boolean admin;
    @SerializedName("push")
    @Expose
    private Boolean push;
    @SerializedName("pull")
    @Expose
    private Boolean pull;

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getPush() {
        return push;
    }

    public void setPush(Boolean push) {
        this.push = push;
    }

    public Boolean getPull() {
        return pull;
    }

    public void setPull(Boolean pull) {
        this.pull = pull;
    }
}
