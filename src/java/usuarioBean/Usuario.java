package usuarioBean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean
@ViewScoped
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private int id;
    private String usuario;
    private String senha;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Column(name = "senha")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public String validarLogin(String usuario, String senha) {
        if (getUsuario().equals("ailton") && getSenha().equals("123")) {
            FacesMessage msg = new FacesMessage("Successful", "Welcome :" + getUsuario());
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bem vindo " + getUsuario()));
            return "index.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dados de login inválidos! ",null));
        }
        return null;
        
    }
    
    public String recuperarSenha(){
        return "recuperarSenha.xhtml";
        
       //teste 1    
        
    }

}
